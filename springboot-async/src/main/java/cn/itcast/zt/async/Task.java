package cn.itcast.zt.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by zhangtian on 2017/4/12.
 */
@Component
public class Task {

    public static Random random = new Random() ;

    @Async //看源码了解一下这个原理，应该是spring有一个任务队列用多线程去跑
    public Future<String> doTaskOne() throws  Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis() ;
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis() ;

        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成！！！") ;
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
