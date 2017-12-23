package test.lambda;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.IntSupplier;

public class TestLambdaMetafacory {
	public static void main(String... arg) throws Throwable {
		System.out.println(new TestLambdaMetafacory().foo().getAsInt());
	}

	public IntSupplier foo() throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodType methodType = MethodType.methodType(int.class);
		MethodType invokedType = MethodType.methodType(IntSupplier.class,
				TestLambdaMetafacory.class);
		MethodHandle methodHandle = lookup.findVirtual(getClass(), "fortyTwo",
				methodType);
		CallSite callSite = LambdaMetafactory.metafactory(lookup, "getAsInt",
				invokedType, methodType, methodHandle, methodType);
		return (IntSupplier) callSite.getTarget().invokeExact(this);
	}

	public int fortyTwo() {
		return 42;
	}
}
