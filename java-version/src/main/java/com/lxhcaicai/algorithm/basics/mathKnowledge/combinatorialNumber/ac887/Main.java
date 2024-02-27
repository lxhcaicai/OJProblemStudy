package com.lxhcaicai.algorithm.basics.mathKnowledge.combinatorialNumber.ac887;

import java.util.Scanner;

public class Main {


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

    static long C(long a,long b,long p) {
        if (b > a) {
            return 0;
        }
        if(b > a - b) {
            b = a - b;
        }
        long x = 1;
        long y = 1;
        for(long i = 1, j = a;i <= b; i ++, j --) {
            x = x * j % p;
            y = y * i % p;
        }
        return x * ksm(y,p - 2, p) % p;
    }

    static long lucas(long a, long b, long p) {
        if(a < p && b < p) {
            return C(a,b,p);
        } else {
            return C(a%p,b%p,p) * lucas(a/p, b/p,p) % p;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long p = scanner.nextLong();
            System.out.println(lucas(a,b,p));
        }
    }

}
