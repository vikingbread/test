package test.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class TestMBean {

	 public static void main(String[] args) throws Exception {  
	        // 创建MBeanServer  
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
	          
	        // 新建MBean ObjectName, 在MBeanServer里标识注册的MBean  
	        ObjectName name = new ObjectName("test.jmx:type=Echo");  
	          
	        // 创建MBean  
	        Echo mbean = new Echo();  
	          
	        // 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)  
	        mbs.registerMBean(mbean, name);  
	  
	          
	        // 在MBeanServer里调用已注册的EchoMBean的print方法  
	        mbs.invoke(name, "print", new Object[] { "haitao.tu"}, new String[] {String.class.getName()});  
	          
	        Thread.sleep(Long.MAX_VALUE);  
	    }  
	
}
