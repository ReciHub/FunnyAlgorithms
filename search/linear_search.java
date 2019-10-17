import java.util.Scanner;
class LinearSearch
{
   public static void main(String args[])
   {
      int counter, numOfElements, itemToSearch, array[];
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter number of elements: ");
      numOfElements = scanner.nextInt(); 
      array = new int[numOfElements]; 
      System.out.println("Enter elements of array: ");
      for (counter = 0; counter < numOfElements; counter++)
        array[counter] = scanner.nextInt();
      System.out.println("Enter element to search: ");
      itemToSearch = scanner.nextInt();
      for (counter = 0; counter < numOfElements; counter++)
      {
         if (array[counter] == itemToSearch) 
         {
           System.out.println(itemToSearch+" is present at "+(counter+1));
           break;
         }
      }
      if (counter == numOfElements)
        System.out.println(itemToSearch + " is not present.");
   }
}