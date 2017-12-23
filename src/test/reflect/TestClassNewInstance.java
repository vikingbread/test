package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClassNewInstance {

	public TestClassNewInstance() {
		System.out.println();
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Constructor<?> c = TestClassNewInstance.class.getConstructors()[0];

		c.newInstance();
	}
}
