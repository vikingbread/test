package test.lambda.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestCollectorsToMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Emp[] emps = IntStream.range(0, 10).mapToObj(x -> new Emp(x % 3, "name" + x))
//				.toArray(Emp[]::new);
//		Map<Integer, String> map = Stream.of(emps).collect(Collectors.toMap(Emp::getId, Emp::getName,(k,v)->v));
//		System.out.println(map);
		Emp[] emps = IntStream.range(0, 10).mapToObj(x -> new Emp(x % 3, x % 5 == 0 ? null : "name" + x))
				.toArray(Emp[]::new);
	//	Map<Integer, String> map = Stream.of(emps).collect(Collector.of(HashMap::new, (m,emp)->m.put(emp.getId(),emp.getName()), (m1,m2)->{m1.putAll(m2);return m1;}, Characteristics.IDENTITY_FINISH));
//		Map<Integer, String> map = Stream.of(emps).collect(HashMap::new, (m,emp)->{m.put(emp.getId(),emp.getName());},HashMap::putAll);
		Map<Integer, String> map = Stream.of(emps).reduce(new HashMap<Integer,String>(), (m,emp)->{m.put(emp.getId(),emp.getName());return m;},(m1,m2)->{m1.putAll(m2);return m1;});
		System.out.println(map);
		
	}
	
	public void t1(){
		List<? super Number> l1 =  new ArrayList<Number>();
		
		
		l1.add(2);
		l1.add(2d);
		l1.add(2.0);
//		l1.add();
		Object a = null;
	//	l1.add(a);
		l1.get(0);
		
		List<? extends Number> l2 = new ArrayList<Integer>();
		
		
		//l2.
	//	t2(l2);
	}
	
	public void t2(List<Integer> l1){
		
	}
	

}

class Emp {
	 
	private Integer id;
 
	private String name;
 
	public Emp(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	//	System.out.println(this);
	}
 
	public Integer getId() {
		return id;
	}
 
	public String getName() {
		return name;
	}
 
	@Override
	public String toString() {
		return "id: " + id + ", name: " + name;
	}
 
}
