class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        boolean flag=true;
        for(int astr:asteroids){
            flag=true;
            while(!st.isEmpty()&& st.peek()>0 && astr<0){
                if(Math.abs(astr)>Math.abs(st.peek())){
                    st.pop();
                    continue;
                }
                if(Math.abs(astr)==st.peek()){
                    st.pop();
                }
                flag=false;
                break;
            }
            if(flag){
                st.push(astr);
            }
        }
        int[] arr = new int[st.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}
