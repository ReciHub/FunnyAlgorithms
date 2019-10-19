import java.util.*;
class Spiral
{
    int ar[][];
    int n;
    Spiral(int nn)
    {
        n=nn;
        ar=new int[n][n];
    }
    void spiral_form(int no,int i,int j,int c)
    {
        if(no>n*n)
        return;
        else
        {
            ar[i][j]=no;
            if(i==c && j<n-c-1)
            spiral_form(no+1,i,j+1,c);
            
            if(j==n-c-1 && i<n-c-1)
            spiral_form(no+1,i+1,j,c);
            
            if(i==n-c-1 && j>c)
            spiral_form(no+1,i,j-1,c);
            
            if(j==c && i>c)
            {
              if(i==c+1)
              {
                 spiral_form(no+1,c+1,c+1,c+1);
              }
              else
              spiral_form(no+1,i-1,j,c);
            }
       }
   }
    void display()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(ar[i][j]+"  ");
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        int nn;
        System.out.println("INPUT:");
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the dimensions of the square matrix:");
        nn=in.nextInt();
        Spiral obj=new Spiral(nn);
        obj.spiral_form(1,0,0,0);
        System.out.println("OUTPUT:");
        System.out.println("DECREASING SPIRAL:");
        obj.display();
    }
}
    
           
            