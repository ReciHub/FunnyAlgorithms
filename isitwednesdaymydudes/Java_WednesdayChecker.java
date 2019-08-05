import java.util.Calendar;

public class WednesdayCheck {
	private final static int wednesday = 4;

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int today = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (today == wednesday) {
			System.out.println("It is Wednesday my dudes");
		} else {
			System.out.println("It is NOT Wednesday my dudes");	
		}
	}
}
