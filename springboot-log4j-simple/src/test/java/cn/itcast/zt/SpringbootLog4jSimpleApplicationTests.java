package cn.itcast.zt;

import cn.itcast.zt.log.demo.LogOnClassDemo;
import cn.itcast.zt.log.demo.OneClassWithDifferentLogger;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootLog4jSimpleApplication.class)
public class SpringbootLog4jSimpleApplicationTests {

	@Autowired
	LogOnClassDemo logOnClassDemo;

	@Autowired
	OneClassWithDifferentLogger oneClassWithDifferentLogger;

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Test
	public void testLog4j() {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}


	@Test
	public void testLogOnFile() {
		logOnClassDemo.showLog();
	}

	@Test
	public void testOneClassWithDiffLogs() {
		oneClassWithDifferentLogger.showLog();
	}
}
