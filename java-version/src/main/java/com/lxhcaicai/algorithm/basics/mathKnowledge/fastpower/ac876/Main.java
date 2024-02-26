package com.lxhcaicai.algorithm.basics.mathKnowledge.fastpower.ac876;

import java.util.Scanner;

public class Main {
    static long ksm(long a, long b, long p) {
        a %= p;
        long res = 1;
        for(; b !=0; b >>= 1) {
            if ((b & 1) == 1) {
                res = res * a % p;
            }
            a = a * a % p;
        }
        return res;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (gcd(a, b) == 1) {
                System.out.println(ksm(a,b - 2, b));
            } else {
                System.out.println("impossible");
            }
        }
    }
}
