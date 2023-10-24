# C++ Shell Sort

This is a C++ implementation of the Shell Sort algorithm. Shell Sort is an efficient sorting algorithm that improves upon the Insertion Sort by sorting elements at larger intervals first and then gradually reducing the gap until the entire array is sorted.

## Getting Started

### Prerequisites

- A C++ compiler (e.g., g++, clang++)
- Basic knowledge of C++ programming

### Usage

1. Clone the repository or download the `shell_sort.cpp` file.

2. Compile the program using your C++ compiler:

   ```bash
   g++ shell_sort.cpp -o shell_sort

Run the compiled program:
The program will prompt you to enter the elements you want to sort. Enter the elements as space-separated values.

The sorted array will be displayed as output.

Algorithm
The Shell Sort algorithm works as follows:

Divide the input array into smaller subarrays by selecting a gap size (usually half the length of the array) and comparing elements that are this gap apart.

Perform Insertion Sort on each subarray.

Gradually reduce the gap size and repeat the process until the gap size becomes 1.

The final pass with a gap size of 1 performs a regular Insertion Sort and fully sorts the array.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
The Shell Sort algorithm is attributed to Donald Shell, who introduced the idea of diminishing increment sorting in 1959.
Author
EmojiSMAH
Feel free to add your name and any additional information you find relevant to your specific implementation.

Contributing
If you'd like to contribute to this project or suggest improvements, please open an issue or create a pull request.