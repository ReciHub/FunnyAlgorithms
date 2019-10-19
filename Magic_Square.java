import java.util.*;
class Magic_Square
{   static int mat[][],n,constant=0;
  
   public static void  main(String args[])
   {
       
       Scanner in=new Scanner(System.in);
       System.out.println("Enter the dimension:");
       n=in.nextInt();
       mat=new int[n][n];
       constant=n*n;
       int no=1,genrow=0,gencol=n/2;
       mat[genrow][gencol]=1;
       genrow-=1;gencol+=1;no=2;
       magic_sq(genrow,gencol,no);
       display();
    }
    public static void magic_sq(int genrow,int gencol,int no)
    {
        if(no<=constant)
        {
            
            if(genrow<0 && gencol>n-1)
            magic_sq(genrow-2,gencol-1,no);
            
            if(genrow<0)
            magic_sq(n-1,gencol,no);
            
            if(gencol>n-1)
            magic_sq(genrow,0,no);
            
            if(mat[genrow][gencol]!=0)
            magic_sq(genrow-2,gencol-1,no);
            
            
            mat[genrow][gencol]=no;
            genrow-=1;
            gencol+=1;
            magic_sq(genrow,gencol,no+1);
        }
        else
        return;
    }
    public static void display()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.println(mat[i][j]+" ");
            System.out.println();
        }
    }
}
            
            
            
            
            
           
       