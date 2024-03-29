package com.lxhcaicai.algorithm.mathematicalKnowledge.inclusionExclusionPrinciple.ac214;

import java.util.Scanner;

public class Main {

    static final int MOD = (int) (1E9 + 7);

    static int N = 25;

    static long[] a = new long[N];
    static long[] inv = new long[N];

    static long ksm(long a, long b) {
        long res = 1;
        for(; b != 0; b >>= 1) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
        }
        return res;
    }

    static long C(long n, long m) {
        if (n < m) {
            return 0;
        }
        long res = 1;
        n %= MOD;
        for(int i = 0; i < m; i ++) {
            res = res * (n - i) % MOD;
        }
        for(int i = 1; i <= m; i ++) {
            res = res * inv[i] % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 20; i ++) {
            inv[i] = ksm(i, MOD - 2);
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long ans = 0;

        for(int i = 0; i < n; i ++) {
            a[i] = scanner.nextLong();
        }

        for(int i = 0; i < ( 1 << n); i ++) {
            long d = m + n - 1;
            int sign = 1;
            for(int j = 0; j < n; j ++) {
                if (((i >> j) & 1) == 1) {
                    sign *= -1;
                    d -= a[j] + 1;
                }
            }
            ans = (ans + C(d, n - 1) * sign) % MOD;
        }
        System.out.println((ans + MOD) % MOD);
    }
}
