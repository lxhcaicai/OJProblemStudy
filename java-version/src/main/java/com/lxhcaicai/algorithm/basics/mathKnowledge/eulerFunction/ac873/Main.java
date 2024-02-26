package com.lxhcaicai.algorithm.basics.mathKnowledge.eulerFunction.ac873;

import java.util.Scanner;

public class Main {

    static long getPhi(int x) {
        long ans = x;
        for(int i = 2; (long) i * i <= x; i ++) {
            if (x % i == 0) {
                ans = ans / i* (i - 1);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) {
            ans = ans / x * (x - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int x = scanner.nextInt();
            System.out.println(getPhi(x));
        }
    }
}
