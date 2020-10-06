import java.util.Scanner;

public class BaseConverter{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number you're converting: ");
        String inpNum = s.next();
        int base = 0;
        do{
            System.out.print("What base is this number in?\nEnter a number (2-35) here: ");
            base = s.nextInt();
        }while(base < 2 || base > 35);
        int newBase = 0;
        do{
            System.out.print("What base is this number being converted to?\nEnter a number here: ");
            newBase = s.nextInt();
        }while(base < 2 || base > 35);
        System.out.println(convert(inpNum, base, newBase));
    }

    public static String convert(String num, int oldbase, int newbase){
        int deci = toDecimal(num, oldbase);
        return toBase(deci, newbase);
    }
    public static int toDecimal(String num, int oldbase){
        if(oldbase == 10)
            return (Integer.parseInt(num));
        int deci = 0;
        for(int x = num.length()-1; x >= 0; x--){
            int power = num.length()-1-x;
            deci+=(Integer.parseInt(num.charAt(x)+"")*Math.pow(oldbase, power));
        }
        return deci;
    }
    public static String toBase(int deci, int newbase){
        if(newbase == 10)
            return deci+"";
        String toRet = "";
        int div = deci, mod = 0;
        while(div != 0){
            mod = div%newbase;
            div = div/newbase;
            toRet=maxCheck(mod)+toRet;
        }
        return toRet;
    }
    public static char maxCheck(int num){
        if(num > 9)
	        return (char)(55+num);
        return (char)(48+num);
    }
}
