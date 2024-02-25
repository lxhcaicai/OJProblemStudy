package com.lxhcaicai.algorithm.basics.mathKnowledge.approximateNumber.ac869;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> getFactor(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; (long)i * i <= n; i ++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n /i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int x = scanner.nextInt();
            List<Integer> list = getFactor(x);
            list.forEach(e -> {
                System.out.printf(e + " ");
            });
            System.out.println();
        }
    }
}
