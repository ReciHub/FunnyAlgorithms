# Instructions for displaying FizzBuzz in Vim

Launch `vim`. Enter the following sequence of keypresses verbatim

*Insert the numbers 1 to 100*

<kbd>o</kbd><kbd>1</kbd><kbd>Esc</kbd><kbd>q</kbd><kbd>q</kbd><kbd>Y</kbd><kbd>p</kbd><kbd>Ctrl-a</kbd><kbd>q</kbd><kbd>9</kbd><kbd>8</kbd><kbd>@</kbd><kbd>q</kbd>

*Add Fizz*

<kbd>g</kbd><kbd>g</kbd><kbd>q</kbd><kbd>q</kbd><kbd>3</kbd><kbd>j</kbd><kbd>0</kbd><kbd>C</kbd><kbd>F</kbd><kbd>i</kbd><kbd>z</kbd><kbd>z</kbd><kbd>Esc</kbd><kbd>q</kbd><kbd>3</kbd><kbd>2</kbd><kbd>@</kbd><kbd>q</kbd>

*Add Buzz*

<kbd>g</kbd><kbd>g</kbd><kbd>q</kbd><kbd>q</kbd><kbd>5</kbd><kbd>j</kbd><kbd>0</kbd><kbd>C</kbd><kbd>B</kbd><kbd>u</kbd><kbd>z</kbd><kbd>z</kbd><kbd>Esc</kbd><kbd>q</kbd><kbd>1</kbd><kbd>9</kbd><kbd>@</kbd><kbd>q</kbd>

*Add FizzBuzz*

<kbd>g</kbd><kbd>g</kbd><kbd>q</kbd><kbd>q</kbd><kbd>1</kbd><kbd>5</kbd><kbd>j</kbd><kbd>0</kbd><kbd>C</kbd><kbd>F</kbd><kbd>i</kbd><kbd>z</kbd><kbd>z</kbd><kbd>B</kbd><kbd>u</kbd><kbd>z</kbd><kbd>z</kbd><kbd>Esc</kbd><kbd>q</kbd><kbd>5</kbd><kbd>@</kbd><kbd>q</kbd><kbd>:</kbd><kbd>1</kbd><kbd>d</kbd><kbd>Enter</kbd>

Voila! Your Vim window should now contain the text of FizzBuzz:

![Vim Screenshot](https://sourcecodeshots.com/image/NDPxJqEA04EJLILzL1OS.png)
