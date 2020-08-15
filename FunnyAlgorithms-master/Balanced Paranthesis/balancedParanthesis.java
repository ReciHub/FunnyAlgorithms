import java.util.*;


public class balancedParanthesis
{
	static int top=-1,n=0,flag=0;
	static int[] stk;

	static void push(int ele)
	{
		stk[++top] = ele;
	}

	static void pop()
	{
		if(top==-1)
			{
				++top;
				flag=1;
				return;
			}

		top--;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Paranthesis (to check if balanced) : ");
		String msg = sc.nextLine();

		n = msg.length();
		stk = new int[n];

		for(int i=0;i<n;i++)
		{
			char c = msg.charAt(i);
			switch(c){
				case '(': push(1);
						  break;
				case ')': pop();
						  break;	
			}
			if(flag==1)
				break;
		}

		if(top==-1 && flag==0)
			System.out.println("Balanced Paranthesis");
		else
			System.out.println("Paranthesis not balanced");
	}
}