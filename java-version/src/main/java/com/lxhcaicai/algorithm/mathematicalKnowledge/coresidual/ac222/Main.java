package com.lxhcaicai.algorithm.mathematicalKnowledge.coresidual.ac222;

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
        y = z - (a/b) *y;
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long L = scanner.nextLong();
        long d = exgcd(m - n, L);
        if ((b - a) % d != 0) {
            System.out.println("Impossible");
        } else {
            x *= (b -a) /d;
            long t = Math.abs(L/d);
            System.out.println((x % t + t) % t);
        }
    }
}
