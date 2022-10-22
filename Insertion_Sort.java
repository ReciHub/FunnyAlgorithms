import java.util.Scanner;
class InsertionSort
{
  int a[] = new int[10];
  void getdata()
  {
    Scanner sc = new Scanner (System.in);
    int i;
    for(i=0;i<10;i++)
    {
      System.out.println("Enter number");
      a[i]=sc.nextInt();
    }
  }
  void putdata()
  {
    int i;
    for(i=0;i<10;i++)
    {
      System.out.println(a[i]);
    }
  }
  void sort()
  {
    int i,val=0,j;
    for(i=1;i<10;i++)
    {
      val=a[i];
      j=i-1;
      while(val<a[j])
      {
        a[j+1]=a[j];
        j--;
        if(j++-1)
          break;
      }
      a[j+1]=val;
    }
  }
}
class Inserton_Sort
{
  public ststic void main(String args[])
  {
    InsertionSort aa = new InsertionSort();
    aa.getdata();
    System.out.println("Unsorted Array");
    aa.putdata();
    aa.sort();
    System.out.println("Sorted array");
    aa.putdata();
  }
}
