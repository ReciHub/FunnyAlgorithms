public class pickACard {
    public static void main(String args[]) {
        
     String[] values = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
     String[] suits = {"\u2663", "\u2665", "\u2666", "\u2660"};
    //#club = "\u2663"
    //#heart = "\u2665"
    //#diamond = "\u2666"
    //#spade = "\u2660"
    
    
    int valueIndex = (int)(Math.random()*13);
    int suitIndex = (int)(Math.random()*4);
    
    String cardValue = values[valueIndex];
    String cardSuits = suits[suitIndex];
    
    System.out.println(""+cardValue+" "+cardSuits);
    
    }
}
