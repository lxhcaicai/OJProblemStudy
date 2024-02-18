package com.lxhcaicai.algorithm.mathematicalKnowledge.coresidual.ac1298;

import java.util.Scanner;

public class Main {

    static final int N = 15;
    static int n;
    static int[] a = new int[N];
    static int[] m = new int[N];

    static long x, y;
    static long exgcd(long a, long b) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        long d = exgcd(b, a%b);
        long z = x;
        x = y;
        y = z - (a/b)*y;
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long M = 1;
        for(int i = 1; i <= n; i ++) {
            m[i] = scanner.nextInt();
            a[i] = scanner.nextInt();
            M *= m[i];
        }
        long ans = 0;
        for(int i = 1; i <= n; i ++) {
            long Mi = M/m[i];
            exgcd(Mi, m[i]);
            long ti = x, yy =y;
            ans = (ans +a[i] * Mi *ti) %M;
        }
        System.out.println((ans % M +M) % M);
    }
}
