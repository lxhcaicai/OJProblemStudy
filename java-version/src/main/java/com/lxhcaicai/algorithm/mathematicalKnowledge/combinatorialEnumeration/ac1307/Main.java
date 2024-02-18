package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1307;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static long[] f = new long[N];
    static final int MOD = 5000011;
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for(int i = 1; i <= k + 1; i ++) {
            f[i] = i + 1;
        }
        for(int i = k + 2; i <= n; i ++) {
            f[i] = (f[i - 1] + f[i - k - 1]) % MOD;
        }
        System.out.println(f[n]);
    }
}
