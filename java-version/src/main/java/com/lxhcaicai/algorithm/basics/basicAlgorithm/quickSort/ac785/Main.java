package com.lxhcaicai.algorithm.basics.basicAlgorithm.quickSort.ac785;

import java.util.Scanner;

public class Main {

    static int N = (int) (1e5 + 100);

    static void quick(int[] a, int l, int r) {
        int mid = a[(l + r) >> 1], i =l, j = r;
        while (i < j) {
            while (a[i] < mid) {
                i ++;
            }
            while (a[j] > mid) {
                j --;
            }
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i ++;
                j --;
            }
        }

        if (i < r) {
            quick(a, i, r);
        }
        if (l < j) {
            quick(a, l, j);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        quick(a, 1, n);
        for(int i = 1; i <= n; i ++) {
            System.out.printf(a[i] + " ");
        }
    }
}
