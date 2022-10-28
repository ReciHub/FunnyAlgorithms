public class trappingRainWater{
    
    public static int rainWater(int height[]){ //O(n)
        //calculate the left max boundry
        int n = height.length;
        int leftMax[] = new int [n];
        leftMax[0] = height[0];
        for(int i=0; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i+1]);
        }

        //calculate the right most max boundry
        int rightMax[] = new int [n];
        rightMax[n-1]= height[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            rightMax[i] = Math.max(height[i], rightMax[i-1]);
        }

        //loop
        int trappedWater = 0;
        for(int i=0 ; i<n;i++){
            //waterLevel = min(leftmaxBoundry ,rightmaxBoundry)
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            
            //trapped water = waterLevel - height[i];
            trappedWater += waterLevel - height[i];
        }
        return trappedWater ;
    }
    public static void main(String[] args) {
       
    int height[] = {4,2,0,6,3,2,5};
    System.out.println(rainWater(height));    
    }  
}
