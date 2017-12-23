package test.lambda;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;

public class ValueCapture {
	public static void main(String[] args) {
		
		Function<Double, Long> fun = LambdaFactory.getLambda();
		System.out.println(fun == LambdaFactory.getLambda());
		System.out.println(fun.apply(3.0));
		
	    String name = "TOM";
	    String hello = "say hello to ";
	 
	    Runnable runner = () -> System.out.println(hello + name);
	    runner.run();
	    
	    Method[] declaredFields = ValueCapture.class.getDeclaredMethods();
	    Stream.of(declaredFields).forEach(System.out::println);
	  }
	
	
	public void doSomething(){
		
//		Consumer<Object> c = this::abc;
//		c.accept(null);
		List<Object> list = ImmutableList.of(1);
		list.forEach(this::abc);
		Runnable runner = () -> System.out.println("");
	}
	
	public void abc(Object obj){
		System.out.println(this);
	}
	// Exception in thread "main" java.lang.ClassFormatError: Duplicate method name&signature in class file test/lambda/ValueCapture
//	 private static void lambda$0(String s, String s2){
//		System.out.println(2); 
//	 }
}
