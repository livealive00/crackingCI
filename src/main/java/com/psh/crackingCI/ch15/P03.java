package com.psh.crackingCI.ch15;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class P03 {

    public static void main(String[] args) {
        int num = 2;
        List<Chopstick> chopsticks = IntStream.range(0, num).mapToObj(i -> new Chopstick(i)).collect(toList());
        IntStream.range(0, num).mapToObj(i -> {
            int rightIdx = i == num-1 ? 0 : i+1;
            return new Philosopher(i, chopsticks.get(i), chopsticks.get(rightIdx));
        }).parallel().forEach(Thread::run);
    }

}

class Philosopher extends Thread {
    private int id;
    private int bites = 5;
    private Chopstick left;
    private Chopstick right;
    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        if (left.getId() < right.getId()) { // smaller first
            this.left = left;
            this.right = right;
        } else {
            this.left = right;
            this.right = left;
        }
    }

    public boolean eat() throws InterruptedException {
        /*if (!this.left.pickUp(id)) {
            return false;
        }
        if (!this.right.pickUp(id)) {
            this.left.putDown(id);
            return false;
        }*/
        this.left.pickUp(id);
        this.right.pickUp(id);

        sleep(RandomUtils.nextInt(10, 20));

        this.right.putDown(id);
        this.left.putDown(id);

        bites--;
        return true;
    }
    @Override
    public void run() {
        while (bites > 0) {
            try {
                //System.out.println("P[" + this.id + "] try to bite [" + bites + "]");
                if (eat()) {
                    System.out.println("P[" + this.id + "] bites [" + bites + "]");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Chopstick {
    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(int pid) {
        //System.out.println("P[" +pid + "] try lock: " + id);
        /*boolean res = this.lock.tryLock();
        if (res) {
            System.out.println("P[" + pid + "] lock: " + id);
        }
        return res;*/
        this.lock.lock();
        return true;
    }

    public void putDown(int pid) {
        //System.out.println("P[" + pid + "] try unlock: " + id);
        this.lock.unlock();
        System.out.println("P[" + pid + "] unlock: " + id);
    }

    public int getId() {
        return this.id;
    }
}