package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

public class TestSocketService {

	public static void main(String[] args) throws IOException {
		ReentrantLock rl = new ReentrantLock();
		ServerSocket ss = new ServerSocket(11);
		rl.lock();
		Socket accept = ss.accept();

	}

}
