package com.lxhcaicai.algorithm.basics.basicAlgorithm.twoPointerAlgorithm.ac800;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        for(int i = 0; i < n; i ++) {
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < m; i ++) {
            b[i] = scanner.nextInt();
        }
        for(int i = 0, j = m-1; i < n; i ++ ) {
            while (j >= 0 && a[i] + b[j] > x) {
                j --;
            }
            if (j >= 0 && a[i] + b[j] == x) {
                System.out.println(i + " " + j);
            }
        }
    }
}
