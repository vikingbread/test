package test;

import java.io.IOException;

public class EscapeAnalysisTest {

	public static void main(String[] args) throws IOException {
		long now = System.currentTimeMillis();
		long sumOfArea = 0;
		for (int i = 0; i < 1000000000; i++) {
			Rectangle rect = new Rectangle(i + 5, i + 10);
			sumOfArea += t1(rect);
		}
		long runTime = System.currentTimeMillis() - now;
		System.out.println("Press anny key ");
		System.in.read();
		System.out.println(sumOfArea);
		System.out.println("time:" + runTime);
	}

	private static int t1(Rectangle rect) {
		int t2 = rect.getArea();
		return t2;
	}

	static class Rectangle {
		private int height;
		private int width;

		public Rectangle(int height, int width) {
			this.height = height;
			this.width = width;
		}

		public int getArea() {
			return height * width;
		}
	}

}
