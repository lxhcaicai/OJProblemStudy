package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac1010;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1010;
    static int a[] = new int[N];
    static int f[] = new int[N];
    static int g[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.hasNext()) {
            a[++ n] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i ++) {
            f[i] = 1;
            g[i] = 1;
            for (int j = 1; j < i; j ++) {
                if (a[i] <= a[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
                if (a[i] > a[j]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
        System.out.println(Arrays.stream(g).max().getAsInt());

    }
}
