package com.lxhcaicai.algorithm.basics.basicAlgorithm.prefixAndDifference.ac797;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 10);
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
            f[i] = a[i] - a[i-1];
        }

        while (m -- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            f[l] += c;
            f[r + 1] -= c;
        }

        for(int i = 1; i <= n; i ++) {
            f[i] += f[i-1];
            System.out.printf("%d ", f[i]);
        }
    }
}
