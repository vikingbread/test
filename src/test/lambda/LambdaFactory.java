package test.lambda;

import java.util.function.Function;

public class LambdaFactory {
	
	
	static Function<Double, Long> getLambda(){
		
		return a->a.longValue();
		
	}

}
