package com.lxhcaicai.algorithm.basics.mathKnowledge.combinatorialNumber.ac889;

import java.util.Scanner;

public class Main {

    static final int MOD = (int) (1E9 + 7);
    static final int N = (int) (2e5 + 100);

    static long[] f = new long[N];
    static long[] inv = new long[N];
    static long[] finv =  new long[N];

    static void init() {
        int n = N - 2;
        inv[0] = inv[1] = finv[0] = finv[1] = f[1] = f[0] = 1;
        for(int i = 2; i <= n; i ++) {
            f[i] = f[i - 1] * i % MOD;
            inv[i] = (MOD- MOD/i) * inv[MOD % i] % MOD;
            finv[i] = finv[i - 1] * inv[i] % MOD;
        }
    }

    static long C(int a, int b) {
        return f[a] * finv[b] % MOD * finv[a -b] % MOD;
    }

    static long Cat(int n) {
        return C(2*n, n) * inv[n + 1] % MOD;
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Cat(n));
    }
}
