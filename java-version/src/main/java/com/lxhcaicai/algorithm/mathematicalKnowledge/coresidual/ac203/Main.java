package com.lxhcaicai.algorithm.mathematicalKnowledge.coresidual.ac203;

import java.util.Scanner;

public class Main {

    static long x, y;
    static long exgcd(long a, long b) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        long d = exgcd(b, a %b);
        long z = x;
        x = y;
        y = z - (a/b)*y;
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        exgcd(a, b);
        long ans = (x %b + b) %b;
        System.out.println(ans);
    }
}
