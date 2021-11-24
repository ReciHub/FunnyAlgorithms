public class hollow_diamond {
	
	public static void main(String[] args) {
		int n = 6;
		int i, j, k = 0;
        for (i = 1; i <= n; i++) 
		{
			for (j = 1; j <= n - i; j++) 
			{
				System.out.print(" ");	
			}
			for (k = 1 ; k <= i * 2 - 1; k++) 
			{
				if (k == 1 || k == i * 2 - 1) {
					System.out.print("#");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for (i = n - 1 ; i > 0; i--) 
		{
			for (j = 1 ; j <= n - i; j++) 
			{
				System.out.print(" ");
			}
			for (k = 1 ; k <= i * 2 - 1; k++) 
			{
				if (k == 1 || k == i * 2 - 1) {
					System.out.print("#");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
   
}