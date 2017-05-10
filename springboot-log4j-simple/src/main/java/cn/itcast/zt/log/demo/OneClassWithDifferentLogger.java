package cn.itcast.zt.log.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Erik_Yim on 2017/5/8.
 * 一个类中定义两个不同logger输出到不同的文件
 */

@Component
public class OneClassWithDifferentLogger {

    Logger logTest = LoggerFactory.getLogger("logTest");
    Logger logOnFile = LoggerFactory.getLogger("cn.itcast.zt.log.demo.LogOnClassDemo");

    public void showLog() {
        logTest.info("this is logTest log demo");
        logOnFile.info("this is logOnFile log demo");
    }
}
