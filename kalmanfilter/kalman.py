"""
The variable's nomenclature of this code is based on the following article:
GPS/IMU data fusion using multisensor Kalman filtering: Introduction of contextual aspects.
F_mat is the matrix that represents the function of the process. In the case of IMU and GPS, Newton's equations for rectilinear motion
identity_mat is an identity array of the order declared in the constructor
B_mat is a unit column array
zero_mat is an array of zeroes of order declared in the constructor
dt is the signal period of the sensors. If the frequency of the data is 10 Hz for example, dt is equal to 0.1 second
H_gps_mat and H_imu_mat are the matrices responsible for changing the vector space between state and sensor data. (modeled according to the cited article)
xk_vector is the state vector of our system. In our case, a vector column of 9 positions, containing the axes x, y, z of the position, velocity and acceleration, respectively
z_imu_mat and z_gps_mat are the matrices containing the data of the respective sensors
P_mat is the covariance matrix of the states.
R_gps_mat and R_imu_mat are the covariance matrices of the sensors, responsible for adding the error to our modeling
Q_mat is the modeling noise of our system, added to the covariance matrix of states
"""

import numpy as np
from numpy.linalg import inv
from numpy.random import randn
np.set_printoptions(formatter={'float': lambda x: "{0:0.3f}".format(x)})


class KalmanFilter:

    F_mat = None
    identity_mat = None
    B_mat = None
    zero_mat = None
    dt = None
    H_gps_mat = None
    H_imu_mat = None
    xk_vector = None
    z_imu_mat = None
    z_gps_mat = None
    P_mat = None
    R_gps_mat = None
    R_imu_mat = None
    Q_mat = None
    control_input = None

    def __init__(self, frequence):

        self.identity_mat = np.identity(3)
        self.B_mat = np.array([[1., 1., 1.]]).T
        self.zero_mat = np.zeros((3, 3))
        self.dt = 1./frequence

        self.__build_F_mat()
        self.__build_H_gps_mat()
        self.__build_H_imu_mat()
        self.__build_state_vector()
        self.__build_state_covariance_matrix()
        self.__build_control_function()
        self.__build_gps_covariance_matrix()
        self.__build_imu_covariance_matrix()
        self.__estimate_noise()
        self.control_input = float()  # gama(k) = control input

    def make_diag_matrix(self, vector):

        # this function exists in numpy 1.14 (python3) as numpy.diag(),
        # but in numpy 1.11 (python2.7) there is not, so we implemented it here
        diag_mat = np.zeros((vector.size, vector.size))
        i = 0
        for element in (vector):
            diag_mat[i, i] = element
            i += 1
        return diag_mat

    def predict(self):
        self.xk_vector = np.dot(self.F_mat, self.xk_vector)
        self.P_mat = np.dot(self.F_mat, self.P_mat).dot(
            self.F_mat.T) + self.Q_mat

    def update(self):

        S_gps_mat = np.dot(self.H_gps_mat, self.P_mat).dot(
            self.H_gps_mat.T) + self.R_gps_mat
        S_imu_mat = np.dot(self.H_imu_mat, self.P_mat).dot(
            self.H_imu_mat.T) + self.R_imu_mat
        K_gps_mat = np.dot(self.P_mat, self.H_gps_mat.T).dot(inv(S_gps_mat))
        K_imu_mat = np.dot(self.P_mat, self.H_imu_mat.T).dot(inv(S_imu_mat))
        y_gps_mat = self.z_gps_mat - np.dot(self.H_gps_mat, self.xk_vector)
        y_imu_mat = self.z_imu_mat - np.dot(self.H_imu_mat, self.xk_vector)
        self.xk_vector = self.xk_vector + \
            np.dot(K_gps_mat, y_gps_mat) + np.dot(K_imu_mat, y_imu_mat)

        Ht_Ri_H_gps = np.dot(self.H_gps_mat.T, inv(
            S_gps_mat)).dot(self.H_gps_mat)
        Ht_Ri_H_imu = np.dot(self.H_imu_mat.T, inv(
            S_imu_mat)).dot(self.H_imu_mat)
        P_inv = inv(self.P_mat) + Ht_Ri_H_gps + Ht_Ri_H_imu
        self.P_mat = inv(P_inv)

    def __build_F_mat(self):

        # F_mat is the process model matrix
        # F_mat = np.array([
        #   [identity_mat, dt*identity_mat, ((dt**2)/2)*identity_mat  ],
        #   [zero_mat,     identity_mat,    dt*identity_mat           ],
        #   [zero_mat,     zero_mat,        identity_mat              ]
        #   ])

        first_line = np.concatenate(
            (self.identity_mat, self.dt*self.identity_mat, ((self.dt**2)/2)*self.identity_mat), axis=1)
        second_line = np.concatenate(
            (self.zero_mat, self.identity_mat, self.dt*self.identity_mat), axis=1)
        third_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.identity_mat), axis=1)
        self.F_mat = np.concatenate(
            (first_line, second_line, third_line), axis=0)

    def __build_H_gps_mat(self):
        # H_gps_mat is the measurement function matrix
        # H_gps_mat = np.array([
        #   [identity_mat, zero_mat, zero_mat],
        #   [  zero_mat  , zero_mat, zero_mat],
        #   [  zero_mat  , zero_mat, zero_mat]
        #   ])

        first_line = np.concatenate(
            (self.identity_mat, self.zero_mat, self.zero_mat), axis=1)
        second_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.zero_mat), axis=1)
        third_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.zero_mat), axis=1)
        self.H_gps_mat = np.concatenate(
            (first_line, second_line, third_line), axis=0)

    def __build_H_imu_mat(self):
        # H_imu_mat is the measurement function matrix
        # H_imu_mat = np.array([
        #   [zero_mat, zero_mat,   zero_mat  ],
        #   [zero_mat, zero_mat,   zero_mat  ],
        #   [zero_mat, zero_mat, identity_mat]
        #   ])

        first_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.zero_mat), axis=1)
        second_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.zero_mat), axis=1)
        third_line = np.concatenate(
            (self.zero_mat, self.zero_mat, self.identity_mat), axis=1)
        self.H_imu_mat = np.concatenate(
            (first_line, second_line, third_line), axis=0)

    def __build_state_vector(self):
        self.xk_vector = np.zeros((9, 1))  # x state variable

    def __build_state_covariance_matrix(self):
        self.P_mat = self.make_diag_matrix(np.array(
            [500., 500., 500., 50., 50., 50., 50., 50., 50.]))  # state covariance matrix

    def __build_measurement_matrix(self, gps_measure_vector, imu_measure_vector):

        measure_matrix = np.concatenate(
            (gps_measure_vector.T, np.zeros((3, 1)), imu_measure_vector.T))
        self.z_imu_mat = np.dot(self.H_imu_mat, measure_matrix)
        self.z_gps_mat = np.dot(self.H_gps_mat, measure_matrix)

    def __build_gps_covariance_matrix(self):
        # measurement covariance matrix gps
        self.R_gps_mat = self.make_diag_matrix(np.ones(9)*.5)

    def __build_imu_covariance_matrix(self):
        # measurement covariance matrix imu
        self.R_imu_mat = self.make_diag_matrix(np.ones(9)*.1)

    def __build_control_function(self):
        self.control_function_mat = np.array(
            [[((self.dt**3)/3)*self.B_mat, ((self.dt**2)/2)
              * self.B_mat, self.dt*self.B_mat]]
        ).T

    def __estimate_noise(self):
        self.Q_mat = np.zeros((9, 9))

    def calculate_kalman_filter(self, gps_measure_vector, imu_measure_vector):
        self.__build_measurement_matrix(gps_measure_vector, imu_measure_vector)
        self.predict()
        self.update()

    def get_state_vector(self):
        return self.xk_vector

    def get_state_covariance_matrix(self):
        return self.P_mat

    # def get_matatrix


def main():
    kalman = KalmanFilter(1.)

    xs = np.array([range(50)]) + randn(50)
    ys = np.array([np.arange(0, 10, .20)]) + randn(50)
    zs = np.array([np.arange(0, 1, .02)]) + randn(50)
    for i in range(50):
        gps_measure_vector = np.array([xs.T[i], ys.T[i], zs.T[i]]).T
        imu_measure_vector = np.array([[.123, 0.12, 0.1231]])
        kalman.calculate_kalman_filter(gps_measure_vector, imu_measure_vector)

    print(kalman.get_state_vector())
    print(kalman.get_state_covariance_matrix())


if __name__ == '__main__':
    main()
