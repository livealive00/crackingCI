package com.psh.crackingCI.ch13;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class P08 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2);
        System.out.println(getRandomSubset(list));
        System.out.println(getRandomSubset(list));
        System.out.println(getRandomSubset(list));
        System.out.println(getRandomSubset(list));
    }

    public static List<Integer> getRandomSubset(List<Integer> list) {
        return list.stream().filter(x -> Math.random() < 0.5).collect(Collectors.toList());
    }
}
