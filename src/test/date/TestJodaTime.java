package test.date;

import org.joda.time.LocalDateTime;

public class TestJodaTime {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString("yyyy-MM-dd HH:mm:ss"));
	}

}
