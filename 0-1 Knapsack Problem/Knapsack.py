''' Knapsack Problem '''

def knapSack(weights, values, capacityWeight, n):
    if n == 0 or capacityWeight == 0 : 
        return 0
   
    if (weights[n-1] > capacityWeight): 
        return knapSack( weights , values ,capacityWeight, n-1) 
  
    else: 
        return max(values[n-1] + knapSack(weights , values ,capacityWeight-weights[n-1], n-1), 
                   knapSack(weights , values,capacityWeight , n-1))
                   
                   
values = [60, 100, 120] 
weights = [10, 20, 30] 
capacityWeight = 50
n = len(values) 
print(knapSack(weights , values , capacityWeight , n))
