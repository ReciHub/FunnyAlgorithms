import java.util.*;
class WaterOverflow
{
       double ar[][];
       int m;
       
       public void input()
       {
           Scanner in=new Scanner(System.in);
           System.out.println("Input:");
           int  K=in.nextInt(); 
           int  i=in.nextInt();
           int  j=in.nextInt();
           m=i+2;
           ar=new double[m][m];
           
           ar[0][0]=K;
           fillglasses(0,0);
           search(i,j);
        }
        public void fillglasses(int i,int j)
        {
            double k=0;
            if(i<m-1)
            {
                if(j<=i) 
                {
                    k=ar[i][j];
                    if(k>=1)
                    {
                        ar[i][j]=1.0;
                        k=(k-1)/2.0;
                        ar[i+1][j]+=k;
                        ar[i+1][j+1]+=k;
                    }
                    fillglasses(i,j+1);
                }
                fillglasses(i+1,0);
            }
            else
            return;
        }
        public void search(int row,int col)
        {
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<=i;j++)
                {
                    if(i==row && j==col)
                    System.out.println("Amount of water="+ar[i][j]+"units");
                }
            }
        }
    }
                    
                   
            
            
            