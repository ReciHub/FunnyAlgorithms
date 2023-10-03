public class IsAnagram{
public boolean checkAnagram(String s, String t) {
        Map<Character,Integer> val = new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            if(!val.containsKey(s.charAt(i))){
                val.put(s.charAt(i),1);
            }else{
                val.put(s.charAt(i),val.get(s.charAt(i))+1);
            }
        }
        boolean found=true;
        for(int i=0;i<t.length();i++){
            if(!val.containsKey(t.charAt(i))){
                val.put(s.charAt(i),1);
                found = false;
                break;
            }else{
                val.put(t.charAt(i),val.get(t.charAt(i))-1);
            }
        }
        for(Map.Entry<Character,Integer> entry : val.entrySet()){
            if(entry.getValue()!=0){
                found = false;
                break;
            }
        }
        return found;
    }
}
