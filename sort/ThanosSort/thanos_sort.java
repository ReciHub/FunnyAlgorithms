import java.util.*;

public class thanos_sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of the elements");
        int size = in.nextInt();
        ArrayList<Integer> l = new ArrayList();
        System.out.println("Enter elements one by one: ");
        for (int i=0;i<size;i++){
            l.add(in.nextInt());
        }
        Collections.sort(l); //O(n logn)
        Random rand = new Random();
        for (int i=0;i<size;i++){ // O(n)
            int rn = rand.nextInt(2); //there will be 50% chance of 0 and 1 respectively
            if(rn == 0) //if 0 comes, remove the element!
                l.set(i,-69); //LOL
        }
        System.out.println("New Thanos'ed Sorted List");
        for (int i=0;i<l.size();i++){
            if(l.get(i) != -69) //LOL
                System.out.println(l.get(i));
        }
    }
}