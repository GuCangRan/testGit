package com.example.threadTest;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试多线程
 * Created by GuaiWenWo on 2021/2/8 16:42
 */
public class threadTestC {

    public static void main(String[] args) {
        Data3 myData = new Data3();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <5; i++) {
            executorService.execute(()->{
                try {
                    myData.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                try {
                    myData.inadd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

class Data3 {
    int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public  void add() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                System.out.println("我死循环的等待");
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public  void inadd() throws InterruptedException {
        lock.lock();

        try {
            while (number == 0) {
                condition.await(10, TimeUnit.SECONDS);
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "->" + number);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
