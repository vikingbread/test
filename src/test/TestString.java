package test;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "abc";
		String s2 = "abc";
		String s3 = null;

		s3 = s1 + s2;

		s3 = new StringBuilder(String.valueOf(s1)).append(s2).toString();

		
		"aaab".replaceAll("aa", "a");
	}

}
