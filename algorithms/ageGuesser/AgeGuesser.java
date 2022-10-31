import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AgeGuesser {

    private static void out(final String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        out("Hello welcome! I'm the Birthday Guesser! ");
        out("Now I'm going to ask you a few questions to know your birthday!");

        out("What year were you born?");
        int yearBirth = scanner.nextInt();


        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();

        int age = getLocalDate.getYear() - yearBirth;

        out("Your age is 1,110 years old! Just kidding, your real age is " + age + ".");

    }

}
