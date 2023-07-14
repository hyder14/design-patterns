package com.hyders.practice.certification;

public class Jail extends Thread {
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(new Jail());
        Thread t2 = new Thread(new Jail());
        t.start();
        t2.start();
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 2; i++)
                System.out.print(Thread.currentThread().getName() + " ");
        }

    }
}
