package test.lambda;

import java.lang.reflect.Array;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class TestRecursiver {
	
	public static void main(String[] args) {
		
		//1
		IntToDoubleFunction[] foo = { null };
		foo[0] = x -> { return  ( x == 0)?1:x* foo[0].applyAsDouble(x-1);};
		System.out.println(foo[0].applyAsDouble(5));
		
		//2
		Function<Long, Long>[] funs = ((ArraySupplier<Function<Long,Long>>)Function[]::new).get(1);
//		Function<Long, Long>[] funs = newArray(Function.class, 1);
//		Function<Long, Long>[] funs = {null}; //Cannot create a generic array of Function<Long,Long>
		funs[0] = x -> {if (x ==1 || x == 2) return 1L; else return funs[0].apply(x -1) + x;};
		System.out.println(funs[0].apply(10L));
		
		//3
		BiFunction<BiFunction, Long, Long> factHelper = (f, x) -> {if (x ==1 || x == 2) return 1L; else return x + (long)f.apply(f,x-1);};
		Function<Long, Long> fib = x -> factHelper.apply(factHelper, x);
		System.out.println(fib.apply(10L));
		
	}
	
	   @SuppressWarnings("unchecked")
	   private static <E> E[] newArray(Class clazz, int size)
	   {
	       return (E[]) Array.newInstance(clazz, size);  
	   }

	  private interface ArraySupplier<T>{
		   T[] get(int size);
	   }
}
