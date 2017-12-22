package test.lambda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Runnable r = (Runnable & Serializable)() -> System.out.println("hello serialization");
		FileOutputStream fos = new FileOutputStream("Runnable.lambda");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(r);
		FileInputStream fis = new FileInputStream("Runnable.lambda");
		ObjectInputStream is = new ObjectInputStream(fis);
		r = (Runnable) is.readObject();
		r.run();

	}

}
