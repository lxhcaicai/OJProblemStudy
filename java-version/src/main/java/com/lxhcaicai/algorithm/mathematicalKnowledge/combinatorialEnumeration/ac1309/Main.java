package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1309;

import java.util.Scanner;

public class Main {

    static int N = (int) (2E3 + 100);

    static long[] f = new long[N];
    static long[] inv = new long[N];
    static long[] finv = new long[N];
    static final int MOD = (int) (1E5 + 3);

    static void pre() {
        inv[0] = f[0] = finv[0] = inv[1] = finv[1] = f[1] = 1;
        for(int i = 2; i < N; i ++) {
            f[i] = f[i - 1] * i % MOD;
            inv[i] = (MOD - MOD/i) * inv[MOD % i] % MOD;
            finv[i] = finv[i - 1] * inv[i] % MOD;
        }
    }

    static long C(int n, int m) {
        if (n < m) {
            return 0;
        }
        return f[n] * finv[n - m] % MOD * finv[m] % MOD;
    }

    static long A(int n, int m) {
        if (n < m) {
            return 0;
        }
        return f[n] * finv[n -m] % MOD;
    }

    public static void main(String[] args) {
        pre();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        long ans = 0;
        for(int i = 0; i <= k; i ++) {
            ans += C(b,i) * A(a,i) % MOD *C(d,k - i) * A(a +c - i, k - i) % MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
