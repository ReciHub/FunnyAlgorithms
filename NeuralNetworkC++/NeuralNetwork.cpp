#include <iostream>
#include <vector>
#include <cmath>

// Define the sigmoid activation function
double sigmoid(double x) {
    return 1.0 / (1.0 + std::exp(-x));
}

// Define the derivative of the sigmoid function
double sigmoid_derivative(double x) {
    double s = sigmoid(x);
    return s * (1.0 - s);
}

// Define the neural network class
class NeuralNetwork {
public:
    NeuralNetwork() {
        // Initialize the layers
        layers_.push_back(std::vector<double>(2, 0.0)); // input layer
        layers_.push_back(std::vector<double>(3, 0.0)); // hidden layer
        layers_.push_back(std::vector<double>(1, 0.0)); // output layer
        // Initialize the random weights and biases
        weights_.push_back(std::vector<std::vector<double>>(3, std::vector<double>(2, 0.0))); // input -> hidden weights
        weights_.push_back(std::vector<std::vector<double>>(1, std::vector<double>(3, 0.0))); // hidden -> output weights
        biases_.push_back(std::vector<double>(3, 0.0)); // hidden biases
        biases_.push_back(std::vector<double>(1, 0.0)); // output bias
        for (int i = 0; i < weights_.size(); i++) {
            for (int j = 0; j < weights_[i].size(); j++) {
                for (int k = 0; k < weights_[i][j].size(); k++) {
                    weights_[i][j][k] = (std::rand() / double(RAND_MAX)) * 2.0 - 1.0;
                }
            }
            for (int j = 0; j < biases_[i].size(); j++) {
                biases_[i][j] = (std::rand() / double(RAND_MAX)) * 2.0 - 1.0;
            }
        }
    }
    // Forward pass through the network
    double forward(double height, double weight) {
        layers_[0][0] = height;
        layers_[0][1] = weight;
        for (int i = 1; i < layers_.size(); i++) {
            for (int j = 0; j < layers_[i].size(); j++) {
                double sum = biases_[i - 1][j];
                for (int k = 0; k < layers_[i - 1].size(); k++) {
                    sum += weights_[i - 1][j][k] * layers_[i - 1][k];
                }
                layers_[i][j] = sigmoid(sum);
            }
        }
        return layers_.back()[0];
    }
private:
    std::vector<std::vector<double>> layers_;
    std::vector<std::vector<std::vector<double>>> weights_;
    std::vector<std::vector<double>> biases_;
};

int main() {
    // Create a neural network
    NeuralNetwork nn;
    // Train the network to predict whether a person is a cat or a dog
    for (int i = 0; i < 10000; i++) {
        double height = (std::rand() / double(RAND_MAX)) * 100.0;
        double weight = (std::rand() / double(RAND_MAX)) * 100.0;
        double target = (height > weight) ? 1.0 : 0.0; // if height > weight, person is a cat; otherwise, person is a dog
        double output = nn.forward(height, weight);
        double error = output - target;
        nn.weights_[1][0][0] -= 0.1 * error * sigmoid_derivative(output) * nn.layers_[1][0];
        nn.weights_[1][0][1] -= 0.1 * error * sigmoid_derivative(output) * nn.layers_[1][1];
        nn.weights_[1][0][2] -= 0.1 * error * sigmoid_derivative(output) * nn.layers_[1][2];
        nn.biases_[1][0] -= 0.1 * error * sigmoid_derivative(output);
        double error_hidden = error * sigmoid_derivative(output) * nn.weights_[1][0][0];
        nn.weights_[0][0][0] -= 0.1 * error_hidden * sigmoid_derivative(nn.layers_[1][0]) * height;
        nn.weights_[0][0][1] -= 0.1 * error_hidden * sigmoid_derivative(nn.layers_[1][0]) * weight;
        nn.biases_[0][0] -= 0.1 * error_hidden * sigmoid_derivative(nn.layers_[1][0]);
        double error_hidden2 = error * sigmoid_derivative(output) * nn.weights_[1][0][1];
        nn.weights_[0][1][0] -= 0.1 * error_hidden2 * sigmoid_derivative(nn.layers_[1][1]) * height;
        nn.weights_[0][1][1] -= 0.1 * error_hidden2 * sigmoid_derivative(nn.layers_[1][1]) * weight;
        nn.biases_[0][1] -= 0.1 * error_hidden2 * sigmoid_derivative(nn.layers_[1][1]);
        double error_hidden3 = error * sigmoid_derivative(output) * nn.weights_[1][0][2];
        nn.weights_[0][2][0] -= 0.1 * error_hidden3 * sigmoid_derivative(nn.layers_[1][2]) * height;
        nn.weights_[0][2][1] -= 0.1 * error_hidden3 * sigmoid_derivative(nn.layers_[1][2]) * weight;
        nn.biases_[0][2] -= 0.1 * error_hidden3 * sigmoid_derivative(nn.layers_[1][2]);
    }
    // Test the network on some inputs
    std::cout << nn.forward(50, 50) << std::endl; // should be close to 0 (dog)
    std::cout << nn.forward(70, 30) << std::endl; // should be close to 1 (cat)
    std::cout << nn.forward(30, 70) << std::endl; // should be close to 0 (dog)
    std::cout << nn.forward(90, 10) << std::endl; // should be close to 1 (cat)
    return 0;
}