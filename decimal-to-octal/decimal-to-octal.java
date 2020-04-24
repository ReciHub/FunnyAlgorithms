class DECToOCT
{
     static int i=1;
    public static void main(String args[])
    {
        int dec, rem, q,j=1;
        Scanner sc = new Scanner(System.in);   
        System.out.println("Enter a Dec number: ");
        dec=sc.nextInt();
        System.out.println("Oct number is : ");
        int[] oct=octal(dec); 
        for(int c=i-1;c>0;c--)
        {
	 System.out.print(oct[c]);
        }
   
    }
static int[] octal(int q)
{
        int a[] = new int[50];
        while(q != 0)
        {
            a[i++] = q%8;
            q= q/8;
        }
        return a;
 }
}
