package cn.itcast.zt.log.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Erik_Yim on 2017/5/8.
 * 用来测试log4j不同的类输出不同的文件，其实就是按照类来区分
 */

@Component
public class LogOnClassDemo {

    Logger logger = LoggerFactory.getLogger(LogOnClassDemo.class);

    public void showLog() {
        logger.info("this is log on class demo");
    }

}

