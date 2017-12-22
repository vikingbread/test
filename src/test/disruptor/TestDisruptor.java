package test.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.math.RandomUtils;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class TestDisruptor {

	public static void main(String[] args) throws InterruptedException {
		EventFactory<LongEvent> eventFactory = new LongEventFactory();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
		        
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
		                ringBufferSize, executor, ProducerType.MULTI,
		                new YieldingWaitStrategy());
		        
		EventHandler<LongEvent> eventHandler = new LongEventHandler();
		disruptor.handleEventsWith(eventHandler);
		        
		disruptor.start();

		
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		    
		for(int i=0;i<ringBufferSize+10;i++){
		
			long sequence = ringBuffer.next();//请求下一个事件序号；
			try {
			    LongEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
			    long data = getEventData();//获取要通过事件传递的业务数据；
			    event.set(data);
			} finally{
			    ringBuffer.publish(sequence);//发布事件；
			}
		}
		Thread.sleep(1000);
		disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
		executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
	}

	private static long getEventData() {
		return RandomUtils.nextLong();
	}

}

class LongEvent
{
    private long value;

    public void set(long value)
    {
        this.value = value;
    }
}

class LongEventFactory implements EventFactory<LongEvent>
{
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}
class LongEventHandler implements EventHandler<LongEvent>
{
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event);
    }
}