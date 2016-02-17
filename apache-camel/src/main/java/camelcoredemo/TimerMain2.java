package camelcoredemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2016-2-17 下午4:17:22 
 */
public class TimerMain2 extends Main{
	public static void main(String[] args) throws Exception {
		TimerMain2 t2 = new TimerMain2();
		t2.enableHangupSupport();
		t2.addRouteBuilder(createRouteBuilder());
		t2.run(args);
	}
	private static RouteBuilder createRouteBuilder() {
		return new TimerRouteBuilder();
	}
}
