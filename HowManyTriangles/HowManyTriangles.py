# Given an array of cartesian coordinates, how many triangles can be successfully created?

import itertools

def countTriangles(coords):
    count = 0
    for comb in itertools.combinations(coords, 3):
        if (not isCollinear(*comb)):
            count += 1
    return count
         
def isCollinear(p1,p2,p3):
    # If all x or all y are the same you have a straight line
    if (p1[0] == p2[0] and p1[0] == p3[0]) or \
        (p1[1] == p2[1] and p1[1] == p3[1]):
        return True

    # Calculate gradients for points
    m1 = (p1[1] - p2[1])/(p1[0] - p2[0]) if((p1[0] - p2[0]) != 0) else 0
    m2 = (p1[1] - p3[1])/(p1[0] - p3[0]) if((p1[0] - p3[0]) != 0) else 0

    # If the gradients m1 & m2 are the same, you have a linear line
    return m1 == m2

COORDS = [[0,0], [1,0], [2,0], [3,0],
                 [1,1], [2,1],
          [0,2], [1,2], [2,2], [3,2]]

triangleCount = countTriangles(COORDS)
print(f"The coordinates provided can be used to create {triangleCount} unique triangles")