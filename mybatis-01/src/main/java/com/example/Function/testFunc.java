package com.example.Function;

//import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

/**
 * Created by GuaiWenWo on 2021/2/9 10:53
 */
public class testFunc {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum1 = LongStream.rangeClosed(0, 100_0000_000).parallel().reduce(0, Long::max);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sum1);

         ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newFixedThreadPool(20);
        executorService1.execute(()->{
            System.out.println("dsdfsdfsdfsf");
        });
//        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(),
//                new ThreadFactory(
//                ) {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return null;
//                    }
//                });
        executorService.execute(()->{
            System.out.println("你妹的");
        });
        executorService.shutdown();
        //TimeUnit.SECONDS.sleep(3);
    }

    class myThread extends Thread{

        @Override
        public void run() {
            super.run();
        }
    }

    class myTrhe1 implements Runnable{

        @Override
        public void run() {
            System.out.println("你妹的的顺丰速递发");
        }
    }

}
