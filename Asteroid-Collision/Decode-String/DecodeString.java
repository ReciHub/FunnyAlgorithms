public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> strt=new Stack<>();
        Stack<Integer> count=new Stack<>();

        int num=0;

        StringBuilder str = new StringBuilder();
        for(Character ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=(num*10)+ch-'0';
            }else if(ch=='['){
                strt.push(str);
                str=new StringBuilder();
                count.push(num);
                num=0;
            }else if(ch==']'){
                StringBuilder temp=str;
                str=strt.pop();
                int count1=count.pop();
                while(count1-- >0){
                    str.append(temp);
                }

            }else{
                str.append(ch);
            }
        }
        return str.toString();
    }
}
