from itertools import permutations
import numpy as np
import matplotlib.pyplot as plt
from IPython.display import display, clear_output

# a function which calculates all permutations of a string 
# and stores them in a list
def allPermutations(str):
     # Get all permutations of string str
     permList = permutations(str)
     l = []
     # print all permutations
     for perm in list(permList):
        l.append(''.join(perm))
     return l
       
N = 6 # Number of Cities
# initialize random coordinates of all cities
pointx = np.random.random((N))
pointy = np.random.random((N))

# dummy strings to calculate permutations
full_str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOQRSTUVWXYZ"
full_str2 = "#abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOQRSTUVWXYZ"
str = full_str[0:N-1]

# calculate all permutations and store them in all_perm list
all_perm = allPermutations(str)

x = np.zeros(N)
y = np.zeros(N)
x[0] = pointx[0]  # initial x coordinate is fixed
y[0] = pointy[0]  # initial y coordinate is fixed

# plotting the fiugre iteratively for all paths
fig = plt.figure()
ax = fig.add_subplot(1, 1, 1) 
for element in all_perm:
    for i in range(N-1):
        ie = element[i]
        x[i] = pointx[full_str2.index(ie)]
        y[i] = pointy[full_str2.index(ie)]
        
    ax.cla()
    ax.plot(x, y,linewidth = 5, color = 'blue') # paths
    ax.scatter(x, y, color = 'red', s = 500) # location of cities
    ax.scatter(x[-1], y[-1], color = 'black', s = 500) # starting point
    display(fig) 
    plt.axis('off')   
    clear_output(wait = True)
    plt.pause(0.05)
