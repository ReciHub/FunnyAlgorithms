int knapsack(int *weights, int *values, int n, int maxWeight, int **output)
{
	//write your code here
    	if(n == 0 || maxWeight == 0) {
		return 0;
	}

    if(output[n][maxWeight]!=-1)
    {
        return output[n][maxWeight];
    }
  
   

        if(weights[n-1] > maxWeight)
        {
            output[n][maxWeight] = knapsack(weights,values,n-1,maxWeight,output);
        }
    
        else
        {
            output[n][maxWeight] = max(knapsack(weights,values,n-1,maxWeight,output), values[n-1] + knapsack(weights,values,n-1,maxWeight-weights[n-1],output));
        }
    
}

int knapsack(int *weights, int *values, int n, int maxWeight)
{
    int ** output = new int*[n+1];
    for(int i=0; i<=n; i++)
    {
        output[i] = new int[maxWeight+1];
        for(int j =0; j<=maxWeight; j++ )
        output[i][j]= -1;
    }
    return knapsack(weights, values, n, maxWeight, output);
}
