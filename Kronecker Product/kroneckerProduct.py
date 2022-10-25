import numpy as np

def kroneckerProduct(n, m, p, q, A, B):
  return np.kron(np.array(A),np.array(B))


n = 2
m = 2 
p = 2
q = 2
A = [[1, 2], 
     [3, 4]]
B = [[0, 5], 
     [6, 7]]

print(kroneckerProduct(n, m, p, q, A, B))
