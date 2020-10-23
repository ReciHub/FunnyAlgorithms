def isValidTriangle(a, b, c):
    ##to be a valid triangle the sum of two sides must be greater than the other side for all sides.
    if ( ((a+b) > c) and ((a+c) > b) and ((b+c) > a)):
        return True
    else:
        return False