import numpy.linalg as linalg
import numpy as np
import matplotlib.pyplot as plt

def pieee(n):
    x = np.zeros((n,4),dtype=np.dtype)
    counter = 0
    for i in range(n):
        x[i,0:2] = np.random.uniform(0.0,1.0,2)  # generate two uniform random numbers
        x[i,2] = linalg.norm(x[i,:], ord=2)
        if (x[i,2]<=1.0): counter += 1
        x[i,3] = 4.0*np.double(counter)/np.double(i+1)
    return x 

n=100000
x = pieee(n)
pi = 2*np.arcsin(1)
errorplt = x[:,3] - pi
fig, axs = plt.subplots(2)
axs[0].plot( list(range(1,n+1)), x[:,3])
axs[0].set_title('Approximated value of Pi vs Iterations')
axs[1].plot( list(range(1,n+1)),  errorplt*100)
axs[1].set_title('%Error vs Iterations')
plt.show()

