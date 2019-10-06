# Floodfill 
# Recursive

def floodFill(self, image, sr, sc, newColor):
    R, C = len(image), len(image[0])
    color = image[sr][sc]
    if color == newColor: return image
    def dfs(r, c):
        if image[r][c] == color:
            image[r][c] = newColor
            if r >= 1: dfs(r-1, c)
            if r+1 < R: dfs(r+1, c)
            if c >= 1: dfs(r, c-1)
            if c+1 < C: dfs(r, c+1)

    dfs(sr, sc)
    return image



Iterative 

def floodFill(self, image, sr, sc, newColor):
    """
    :type image: List[List[int]]
    :type sr: int
    :type sc: int
    :type newColor: int
    :rtype: List[List[int]]
    """
    if(image[sr][sc]==newColor):
        return image
    temp=image[sr][sc]
    stack=[(sr,sc)]
    while(stack):
        i,j=stack.pop()
        if(image[i][j]==temp):
            image[i][j]=newColor    
            if(i+1<len(image)):
                stack.append((i+1,j))
            if(i-1>=0):
                stack.append((i-1,j))
            if(j+1<len(image[0])):
                stack.append((i,j+1))
            if(j-1>=0):
                stack.append((i,j-1))
        else:
            pass
    return image