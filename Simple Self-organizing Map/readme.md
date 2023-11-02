# Self-Organizing Map (SOM) - README

## Introduction

This project is a Python script that implements a basic Self-Organizing Map (SOM) or competitive learning network. The SOM is used for unsupervised clustering, where input vectors are assigned to one of two output units (neurons) based on their Euclidean distances from the output units. The code allows you to specify the number of input units, learning rate, and whether to use random input values or input specific values.

## Features

- Basic implementation of a Self-Organizing Map (SOM).
- User-defined number of input units.
- Customizable learning rate (alpha).
- Option to input individual values for input units or use random values.
- Calculates Euclidean distances and updates output unit weights.
- Outputs which cluster each input unit belongs to (1st or 2nd).

## Getting Started

### Prerequisites

- Python (3.x recommended)
- NumPy (for numerical operations)

### Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/your-username/self-organizing-map.git
   ```

2. Navigate to the project directory:

   ```bash
   cd self-organizing-map
   ```

3. Run the Python script:

   ```bash
   python som.py
   ```

Follow the on-screen instructions to provide input parameters and run the SOM algorithm.

## Usage

- When prompted, enter the number of input units.
- Enter the learning rate (alpha).
- Choose whether to input individual values for input units or use random values.
- If you input individual values, provide the values row-wise, separated by spaces.
- The script will calculate Euclidean distances and update weights for each input unit.
- After all updates are done, the script will display the final results, indicating which cluster each input unit belongs to.

