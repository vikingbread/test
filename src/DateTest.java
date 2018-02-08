import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date end = df.parse("2018-01-01");
		
		System.out.println(new Date().before(end));
		
	}
}
