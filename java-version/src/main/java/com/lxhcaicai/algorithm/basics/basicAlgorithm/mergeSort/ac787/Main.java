package com.lxhcaicai.algorithm.basics.basicAlgorithm.mergeSort.ac787;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 10);
    static int[] a = new int[N];
    static int[] b = new int[N];
    static void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int i = l;
        int j = mid + 1;
        for(int k = l; k <= r; k ++) {
            if (j > r || i <= mid && a[i] <= a[j]) {
                b[k] = a[i ++];
            } else {
                b[k] = a[j++];
            }
        }
        for(int k = l; k <= r; k ++) {
            a[k] = b[k];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        mergeSort(1, n);
        for(int i = 1; i <= n; i ++) {
            System.out.printf(a[i] + " ");
        }
    }
}
