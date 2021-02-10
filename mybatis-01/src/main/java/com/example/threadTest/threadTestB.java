package com.example.threadTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试多线程
 * Created by GuaiWenWo on 2021/2/8 16:42
 */
public class threadTestB {

    public static void main(String[] args) {
        Data2 myData = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myData.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myData.inadd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();

        Map<Object, Object> cm = new ConcurrentHashMap<>();
        Semaphore semaphore=new Semaphore(2);
    }
}

class Data2 {
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
