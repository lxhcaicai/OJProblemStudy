package com.lxhcaicai.algorithm.mathematicalKnowledge.fastPower.ac1290;

import java.util.Scanner;

public class Main {

    static final int MOD = (int) (1E5 + 3);

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long res = m * ksm(m -1, n -1) % MOD;
        long ans = ksm(m,n);
        System.out.println((ans - res +MOD) % MOD);
    }
}
