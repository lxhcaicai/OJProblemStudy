package com.lxhcaicai.algorithm.basics.basicAlgorithm.twoPointerAlgorithm.ac816;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m ; i++) {
            b[i] = scanner.nextInt();
        }
        for(int i = 1, j = 1; i <= m; i ++) {
            if (j <= n && a[j] == b[i]) {
                j ++;
                if (j > n) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
