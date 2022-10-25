import java.util.Scanner;
class Selection_Sort
{
  int a[] = new int[10];
  void getdata()
  {
    Scanner sc = new Scanner(System.in);
    int i;
    for(i=0;i<10;i++)
    {
      System.out.println("Enter Number :-");
      a[i]=sc.nextInt();
    }
  }
  void sort()
  {
    int i,j,t;
    for (i=0;i<9;i++)
    {
      for(j=i+1;j<10;j++)
      {
        if(a[i]>a[j])
        {
          t=a[i];
          a[i]=a[j];
          a[j]=t;
        }
      }
    }
  }
  void putdata()
  {
    int i;
    for(i=0;i<10;i++)
    System.out.println(a[i]);
  }
}
class selection
{
  public static void main(String args[])
  {
    Selection_Sort aa = new Selection_Sort();
    aa.getdata();
    System.out.println("Unsorted Array :-");
    aa.putdata();
    System.out.println("Sorted Array :-");
    aa.sort();
    aa.putdata();
  }
}
