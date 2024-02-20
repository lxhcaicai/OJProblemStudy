package com.lxhcaicai.algorithm.basics.basicAlgorithm.quickSort.ac786;

import java.util.Scanner;

public class Main {

    static int N = (int) (1e5 + 100);

    static int findK(int[] a, int l, int r,int k) {
        if (l >= r) {
            return a[l];
        }
        int mid = a[(l + r) >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i ++;
            }while (a[i] < mid);

            do {
                j --;
            } while (a[j] > mid);

            if (i <j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if (j - l + 1 >= k) {
            return findK(a, l, j, k);
        }
        else {
            return findK(a, j + 1, r, k - (j - l + 1));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n + 10];
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        int t = findK(a, 1, n, k);
        System.out.println(t);
    }
}
