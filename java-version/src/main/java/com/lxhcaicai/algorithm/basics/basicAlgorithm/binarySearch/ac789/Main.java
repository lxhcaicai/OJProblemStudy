package com.lxhcaicai.algorithm.basics.basicAlgorithm.binarySearch.ac789;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] a = new int[N];

    static int findBegin(int[] a, int l, int r, int k) {
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= k) {
                r = mid - 1;
                pos = mid;
            } else {
                l = mid + 1;
            }
        }
        if (pos == -1) {
            return -1;
        } else {
            if(a[pos] == k) {
                return pos;
            } else {
                return -1;
            }
        }
    }

    static int findEnd(int[] a, int l, int r, int k) {
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (a[mid] <= k) {
                l = mid + 1;
                pos = mid;
            } else {
                r = mid - 1;
            }
        }
        if (pos == -1) {
            return -1;
        } else {
            if(a[pos] == k) {
                return pos;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 0; i < n; i ++) {
            a[i] = scanner.nextInt();
        }
        while (m -- > 0) {
            int k = scanner.nextInt();
            System.out.println(findBegin(a, 0, n-1, k) + " " + findEnd(a, 0, n-1, k));
        }
    }
}
