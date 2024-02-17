package com.lxhcaicai.algorithm.mathematicalKnowledge.fastPower.ac1289;

import java.util.Scanner;

public class Main {

    static int MOD = 200907;

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
        int T = scanner.nextInt();
        for(; T > 0; T --) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long c = scanner.nextInt();
            long k = scanner.nextInt();
            if (2 * b == a +c) {
                long d = b - a;
                System.out.println((a + (k - 1)*d) % MOD);
            }
            else {
                long d = b / a;
                System.out.println(a*ksm(d, k - 1) % MOD);
            }
        }
    }
}
