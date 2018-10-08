# This Script Will tell if you are a robot
import time
import sys

questions = ["Ready to know if you are a robot?\n",
"What is 2+2?\n",
"Good to know that you know basic math, but lets get real...\n",
"What is the answer of the universe, life and everything?\n",
"I want to believe that you are not a robot. Last Question...\n",
"What is the key? Only robots would know\n"
]

def delayPrint(string):
    for letter in string:
        sys.stdout.write(letter)
        sys.stdout.flush()
        time.sleep(0.2)

def delayInput(string):
    delayPrint(string)
    return input()

delayInput(questions[0])
a1 = int(delayInput(questions[1]))
if(a1 == 4):
    delayPrint(questions[2])
    a2 = int(delayInput(questions[3]))
    if(a2 == 42):
        delayPrint(questions[4])
        a3 = delayInput(questions[5])
        if(a3 == "i'm a robot"):
            delayPrint("You truly are a robot\n")
        else:
            print("You aren't a robot\n")
    else:
        print("You aren't a robot\n")
else:
    print("You aren't a robot\n")

