package test.lambda.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestJoining {

	public static void main(String[] args) {
		String collect = IntStream.range(0, 11).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(collect);

	}

}
