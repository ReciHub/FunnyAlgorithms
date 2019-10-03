// this is the working solution for problem on geeks for geeks
// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

class GfG
    {
        static void solve(int [][] arrays,int k,int index,ArrayList<Integer> ans)
        {
            if(index>=k) //check
            {
                return;
            }
            int la=ans.size();
            int put[]=arrays[index];
            if(la==0) {
            
                for(int j=0;j<k;j++)
                {
                    ans.add(put[j]);
                }
                solve(arrays,k,index+1,ans);
            }
            else
            {
                int i=0,j=0;
                while(true)
                {
                    if(i>=ans.size() || j>=k)
                        break;
                    if(put[j]<ans.get(i))
                    {
                        ans.add(i,put[j]);
                        j++;
                    }
                    else
                        i++;
                }
                while(j<k)
                {
                    ans.add(put[j]);
                    j++;
                }
                    
                    
                solve(arrays,k,index+1,ans);
            }
            
        }
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
        {
            ArrayList<Integer> ans= new ArrayList<>();
            
            solve(arrays,k,0,ans);
            
            return ans;
        }
}