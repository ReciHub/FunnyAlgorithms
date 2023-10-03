import java.util.LinkedList;
import java.util.Queue;

public class hot_potato {

    public static void main(String[] args){
        Queue<String> names = new LinkedList<>();

        names.add("Nick");
        names.add("John");
        names.add("Connor");
        names.add("Mike");
        names.add("Paul");

        System.out.println(hotPotato(names, 12));

    }

    public static String hotPotato(Queue<String> names, int repetitions){
        for (int i=0; i<repetitions; i++){
            String person = names.poll();
            names.add(person);
        }
        String personWhoGotCaught = names.poll();

        return personWhoGotCaught;
    }
}
