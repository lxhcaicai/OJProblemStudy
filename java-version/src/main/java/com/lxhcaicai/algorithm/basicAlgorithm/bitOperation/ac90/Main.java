package com.lxhcaicai.algorithm.basicAlgorithm.bitOperation.ac90;

import java.util.Scanner;

public class Main {

    static long quick(long a, long b, long p) {
        long res = 0;
        for(; b != 0; b >>= 1) {
            if ((b&1) == 1) {
                res = (res + a) % p;
            }
            a = a * 2 %p;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long p = scanner.nextLong();
            System.out.println(quick(a, b, p));
        }

    }
}
