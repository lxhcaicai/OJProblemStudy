package com.lxhcaicai.algorithm.basics.mathKnowledge.combinatorialNumber.ac886;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static final int MOD = (int) (1e9 + 7);

    static long[] fac = new long[N];
    static long[] inf = new long[N];

    static long ksm(long a, long b, long p) {
        long res = 1;
        for(;b != 0; b >>= 1) {
            if ((b & 1) ==1) {
                res = res * a % p;
            }
            a = a * a % p;
        }
        return res;
    }

    static void init() {
        fac[0] = inf[0] = 1;
        for(int i = 1; i < N; i ++) {
            fac[i] = fac[i - 1] * i % MOD;
            inf[i] = inf[i - 1] * ksm(i, MOD -2, MOD) % MOD;
        }
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(fac[a] * inf[b] % MOD * inf[a - b] % MOD);
        }
    }
}
