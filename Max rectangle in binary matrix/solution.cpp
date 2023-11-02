class Solution{
    
    private:
    vector<int> prevsmelement(vector<int> ans ,int n){
        stack<int> s;
        s.push(-1);
        vector<int> arr(n);
        
        for(int i = 0 ;i<n ;i++){
            int curr = ans[i];
            while(s.top()!= -1 && ans[s.top()]>= curr){
                s.pop();
            }
            
            arr[i] = s.top();
            s.push(i);
        }
        return arr;
    }
    
    
    vector<int> nextsmelement(vector<int> ans ,int n){
        stack<int> s;
        s.push(-1);
        vector<int> arr(n);

        
        for(int i = n-1 ; i>= 0 ; i--){
            int curr = ans[i];
            while(s.top()!= -1 && ans[s.top()]>= curr){
                s.pop();
            }
            
            arr[i] = s.top();
            s.push(i);
        }
        return arr;
    }
    
    
    
    int histogram(vector<int> ans , int n ){
        vector<int> next = nextsmelement(ans , n);
        vector<int> prev = prevsmelement(ans , n);
        int area = INT_MIN;
        
        for(int i = 0; i<n ; i++){
            int l = ans[i];
            
            if(next[i] == -1)
            next[i] = n;
            
            int b = next[i] - prev[i] - 1;
            
            int newarea = l*b;
            area = max(newarea , area);
            
        }
        
        return area;
    }
    
  public:
    int maxArea(int M[MAX][MAX], int n, int m) {
        // Your code here
        vector<int> ans(m , 0);
        int maxi = INT_MIN;
        
        for(int i = 0 ; i<n ; i++){
        for(int j = 0 ; j<m ; j++)
            if(M[i][j] == 1)
            ans[j]++;
            else ans[j] = 0;
            
            maxi = max(maxi , histogram(ans , m));
            
        }
        
        return maxi;
    }
};
