package com.beust;

public class MethodRefDemo {
    public void f() {
        Runnable w = MethodRefDemo::doWork;
    }

    public static void main(String[] args) {
        new Thread(MethodRefDemo::doWork).start();
        new Thread(() -> doWork()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();
    }

    static void doWork() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 50; i++) {
            System.out.printf("%s: %d%n", name, i);
            try {
                Thread.sleep((int) (Math.random() * 50));
            } catch (InterruptedException ie) {
            }
        }
    }
}