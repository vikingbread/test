package test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public class TestObjectFactory {

	public static void main(String[] args) throws JsonProcessingException {

		JsonNodeFactory factory = new JsonNodeFactory(false);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = factory.objectNode();

		ValueNode pojoNode = factory.pojoNode(new A(1,"hello"));
		
//		node.setAll(pojoNode);
//		mapper.creat
		ObjectNode convertValue = mapper.convertValue(pojoNode, ObjectNode.class);
		convertValue.put("status", 200);
		convertValue.put("result", "ok");
		String str = mapper.writeValueAsString(convertValue);
		System.out.println(str);

	}

}

class A {

	private int id;
	private String name;

	A(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}