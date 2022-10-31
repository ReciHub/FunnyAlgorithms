def stoogesort(L, i=0, j=None):
  if j is None:
    j = len(L) - 1
  if L[j] < L[i]:
    L[i], L[j] = L[j], L[i]
  if j - i > 1:
    t = (j - i + 1) // 3
    stoogesort(L, i  , j-t)
    stoogesort(L, i+t, j  )
    stoogesort(L, i  , j-t)
  return L
 
 
numbers = [2,4,6,8,10,9,7,5,3,1]
print(numbers)
 
numbers = stoogesort(numbers)
print(numbers)

