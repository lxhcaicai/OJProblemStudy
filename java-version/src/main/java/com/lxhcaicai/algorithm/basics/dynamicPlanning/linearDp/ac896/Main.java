package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac896;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);
    static int[] a = new int[N];
    static int tot = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            if (tot == 0 || a[tot] < x) {
                a[++tot] = x;
            } else {
                int l = 1, r = tot;
                int pos = l;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (a[mid] >= x) {
                        pos = mid; r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                a[pos] = x;
            }
        }
        System.out.println(tot);
    }
}
