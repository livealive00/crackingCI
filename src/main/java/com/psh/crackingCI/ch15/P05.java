package com.psh.crackingCI.ch15;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

import static sun.nio.ch.IOStatus.check;

public class P05 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> foo.first());
        Thread t2 = new Thread(() -> foo.second());
        Thread t3 = new Thread(() -> foo.third());
        t3.start();
        t2.start();
        t1.start();

    }
}

class Foo {
    boolean[] call = new boolean[3];

    Semaphore sem1 = new Semaphore(1);
    Semaphore sem2 = new Semaphore(1);

    public Foo() {
        try {
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void first() {
        System.out.println("first");
        sem1.release();
    }

    public void second() {
        try {
            sem1.acquire();
            System.out.println("second");
            sem2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            System.out.println("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
