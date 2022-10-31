def matrix(x, y):
    matrix = [[0 for j in range(1,x+1)] for i in range(1,y+1)] 
    return matrix

if __name__ == "__main__":
    m = matrix(3,4)
    print('\n'.join([''.join(['{:4}'.format(item) for item in row]) 
      for row in m]))