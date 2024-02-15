package com.lxhcaicai.algorithm.basicAlgorithm.recursion.ac97;

import java.util.Scanner;

public class Main {

    static final int MOD = 9901;

    static long ksm(long a, long b) {
        long res = 1;
        a %= MOD;
        for(; b !=0; b >>= 1) {
            if ((b & 1)==1) {
                res = res * a % MOD;
            }
            a = a * a %MOD;
        }
        return res;
    }

    static long sum(int p, int c) {
        if (c == 0) {
            return 1;
        }
        if ((c & 1) ==1 ) {
            return ((1 + ksm(p, (c + 1) >> 1)) * sum(p, (c - 1) >> 1)) % MOD;//奇数的情况下
        }
        else {
            return ((1+ksm(p,c>>1))*sum(p,(c>>1)-1)+ksm(p,c))%MOD;//偶数的情况下
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a == 0) {
            System.out.println(0);
        } else {
            long ans = 1;
            for(int i = 2; i <= a; i ++) {
                int s = 0;
                while (a % i == 0) {
                    s ++;
                    a /= i;
                }
                if(s != 0) {
                    ans = ans *(sum(i, s*b)) % MOD;
                }
            }
            System.out.println(ans);
        }
    }
}
