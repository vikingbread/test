package test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

public class TestPD {
	
	public static void main(String[] args) throws IntrospectionException {
		
		Target t = new Target();
		
		PropertyDescriptor pd = new PropertyDescriptor("bool", Target.class);
		
		
		System.out.println(pd.getReadMethod());
		
	}

	private static class Target{
		
		boolean bool;

		public boolean getBool() {
			return bool;
		}

		public void setBool(boolean bool) {
			this.bool = bool;
		}
		
		
		
	}
}
