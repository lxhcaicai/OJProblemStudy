package com.lxhcaicai.algorithm.basicAlgorithm.prefixAndDifference.ac100;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        b[1] = a[1];
        long res1 = 0, res2 = 0;
        for(int i =2 ; i <= n; i ++) {
            b[i] = a[i] - a[i-1];
            if (b[i] > 0) {
                res1 += b[i];
            } else {
                res2 -= b[i];
            }
        }
        System.out.println(Math.max(res1, res2));
        System.out.println(Math.abs(res1 - res2) + 1);
    }
}
