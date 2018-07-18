package com.psh.crackingCI.ch15;

import com.google.common.collect.Lists;

import java.util.function.Function;

public class P06 {

    public static void main(String[] args) {
        int n = 100;
        Lists.newArrayList(
            new FizzBuzz(true, false, (i) -> "Fizz " + i, n),
            new FizzBuzz(false, true, (i) -> "Buzz " + i, n),
            new FizzBuzz(true, true, (i) -> "FizzBuzz " + i, n),
            new FizzBuzz(false, false, (i) -> i.toString(), n)
        ).forEach(t -> t.start());

    }

    public static class FizzBuzz extends Thread {

        public static final Object lock = new Object();
        public static int current = 1;
        private boolean div3;
        private boolean div5;
        private Function<Integer, String> msgGen;
        private int max;

        public FizzBuzz(boolean div3, boolean div5, Function<Integer, String> msgGen, int max) {
            this.div3 = div3;
            this.div5 = div5;
            this.msgGen = msgGen;
            this.max = max;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (current > max) {
                        return;
                    }

                    if (div3 == (current % 3 == 0) && div5 == (current % 5 == 0)) {
                        System.out.println(msgGen.apply(current));
                        current++;
                    }

                }
            }
        }
    }
}


