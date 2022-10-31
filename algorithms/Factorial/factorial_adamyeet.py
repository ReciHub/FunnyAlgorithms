

putin=input("What number you wanna factorial my lad? Input = ")
if (putin.isdigit()):
    putin=int(putin) #checking if the input is an integer - to differentiate between stop and a request
while (putin != "stop"):
    
    answer = 1

    for f in range(putin,0, -1):
        answer=answer*f 
    print(answer)
    putin=input("What number you wanna factorial my lad? (type stop to stop) Input = ")
    if (putin.isdigit()): #copy of first few lines to be able to input multiple times
        putin=int(putin)

