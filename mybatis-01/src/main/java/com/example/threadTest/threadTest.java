package com.example.threadTest;

/**
 * 测试多线程
 * Created by GuaiWenWo on 2021/2/8 16:42
 */
public class threadTest {

    public static void main(String[] args) {
        Data myData = new Data();
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


    }
}

class Data {

    int number = 0;

    public synchronized void add() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "->" + number);
        this.notify();
    }

    public synchronized void inadd() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "->" + number);
        this.notify();
    }

}
