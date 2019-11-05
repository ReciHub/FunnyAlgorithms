

"""
Sleep sort using Python multiprocessing module

Idea: 
- read a number n from a list
- spawn a new process
- within the process
    - sleep n seconds
    - print that number

Question - for how many numbers would it work?
"""

from multiprocessing import Process
import time

def worker(n):
    time.sleep(n)
    print (n)

def main():
    numbers = [4, 3, 6, 1, 5, 7, 0, 9, 6, 8]
    for n in numbers:
        p = Process(target = worker, args = (n, ))
        p.start()

if __name__ == '__main__':
    main()