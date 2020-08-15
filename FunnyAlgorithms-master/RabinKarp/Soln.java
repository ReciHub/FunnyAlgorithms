//User function Template for Java
class match
{
     static int d= 256;
    
    static boolean search(String pat, String txt, int q)
	    {
	            // Your code here
	            q=3;
	            int n=txt.length();
	            int m=pat.length();
	            int p=0;//pattern hash
	            int t=0;//text hash
	            int h=1;
	            
	            //calc h
	            h=(int)Math.pow(d,m-1)%q;
	            
	            //p and t for pat and first window
	            for(int i=0;i<m;i++)
	            {
	            	t=(d*t+txt.charAt(i))%q;
	            	p=(d*p+pat.charAt(i))%q;
	            }
	            
	            //iterate through for all substring of length m
	            int j=0;
	            for(int i=0;i<=n-m;i++)
	            {
	            	//hash value match match chars
	            	if(t==p)
	            	{
	            		for(j=0;j<m;j++)
	            		{
	            			if(txt.charAt(i+j)!=pat.charAt(j))
	            			{
	            				break;
	            			}
	            		}
	            		if(j==m)
	            		{
	            			return true;
	            		}
	            	}
	            	//rehashing for next iteration
	            	if(i<n-m)
	            	{
	            		t=((d*(t-txt.charAt(i))*h)+txt.charAt(i+m))%q;
	            		
	            		//t can turn out to be positive
	            		if(t<0)
	            			t=t+q;
	            		
	            	}
	            }
	            return false;
	    }
}