package test.jprofiler;

public class Test extends Thread{
    public static void main(String[] args) throws InterruptedException {
        for(int i=1; i<10000; i++) {
            new HelloWorld();
            Thread.sleep(100); // 休眠100毫秒
        }
    }
}

class HelloWorld {
    public HelloWorld() {
        System.out.println("Hello Jayzee!");
    }
}