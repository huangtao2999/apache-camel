package camelcoredemo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2016-2-17 上午10:33:43 
 */
public class TimerMain {
	private static Logger logger = LoggerFactory.getLogger(TimerMain.class);
	public static void main(String[] args) throws Exception {
		new TimerMain().run();
	}
	private void run() throws Exception {
		final CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(createRouteBuilder());
		camelContext.setTracing(true);
		camelContext.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
			try {
			camelContext.stop();
			} catch (Exception e) {
			throw new RuntimeException(e);
			}
			}
			});
		waitForStop();
	}
	
	private RouteBuilder createRouteBuilder() {
		return new TimerRouteBuilder();
	}

	private void waitForStop() {
		while (true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
