# Joke Generator

This simple Python application generates jokes using the PyJokes library and provides a graphical user interface (GUI) for the user to view jokes.

## Prerequisites
- Python installed on your system
- The `turtle` and `tkinter` libraries

## Installation
1. Clone the repository or download the `joke_generator.py` file to your local machine.
2. Navigate to the project directory.
3. Run the Python script.



## Usage
1. Upon running the script, a turtle graphics window and a tkinter GUI window will open.
2. The turtle graphics window displays a welcome message.
3. Click the "New Joke" button in the GUI window to generate a new joke.
4. The generated joke will be displayed in the turtle graphics window.

## Dependencies
- `turtle`: A Python standard library module used for creating simple graphics applications.
- `tkinter`: Python's standard GUI (Graphical User Interface) package.
- `pyjokes`: A Python library for getting random jokes.

## How it Works
1. The turtle graphics window is initialized with a welcome message.
2. The tkinter window contains a button labeled "New Joke."
3. When the "New Joke" button is clicked, the `display_joke()` function is called.
4. The `pyjokes.get_joke()` function is used to fetch a random joke.
5. The fetched joke is displayed in the turtle graphics window, replacing the previous joke.

## Author
[Your Name]
[Your Email Address]

Feel free to reach out to me if you have any questions or suggestions!
