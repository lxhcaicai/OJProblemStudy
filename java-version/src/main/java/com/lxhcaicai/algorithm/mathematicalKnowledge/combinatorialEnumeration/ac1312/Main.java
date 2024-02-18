package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1312;

import java.util.Scanner;

public class Main {

    static final int MOD = (int) (1E6 + 3);

    static long ksm(long a, long b) {
        long res = 1;
        for(;b != 0; b >>= 1) {
            if ((b&1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
        }
        return res;
    }

    static long C(int a, int b) {
        long res = 1, inv = 1;
        for(int i = 1, j = a; i <= b; i ++, j --) {
            res = res * j  % MOD;
            inv = inv * i % MOD;
        }
        res = res * ksm(inv, MOD - 2) % MOD;
        return res;
    }


    static long lucas(int a, int b) {
        if (a < MOD && b < MOD) {
            return C(a,b);
        }
        return C(a%MOD, b%MOD) * lucas(a/MOD, b/MOD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(; T > 0; T --) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int m = r - l;
            long res = lucas(m + n + 1, m + 1) -1;
            System.out.println((res%MOD + MOD) % MOD);
        }
    }
}
