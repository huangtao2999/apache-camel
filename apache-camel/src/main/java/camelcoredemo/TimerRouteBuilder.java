package camelcoredemo;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2016-2-17 上午10:14:34 
 */
public class TimerRouteBuilder extends RouteBuilder{
	private static Logger logger = LoggerFactory.getLogger(TimerRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		from("timer://timer1?period=1000").process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				logger.info("processing {}",arg0);
				
			}
		});
		
	}

}
