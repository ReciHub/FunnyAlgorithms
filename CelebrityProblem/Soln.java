class Celebrity
{
    
    int getId(int m[][], int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        //push all celebs into stack
        for( int i=0;i<n;i++)
        {
                st.push(i);
            
        }
        //pop 2 chack status of matrix
        while(st.size()!=1)
        {
        int a=st.pop();
        int b=st.pop();
        if(m[a][b]==1)
        {
            st.push(b);
        }
        else
        {
            st.push(a);
        }    
        }
        int c=st.pop();
        //checking the last remaining person on the stack eleigible to be a celebrity
        for(int j=0;j<n;j++)
        {
            if(c!=j&&(m[c][j]==1||m[j][c]!=1))
            return -1;
            
        }
        return c;
        
        
        
    }
}
