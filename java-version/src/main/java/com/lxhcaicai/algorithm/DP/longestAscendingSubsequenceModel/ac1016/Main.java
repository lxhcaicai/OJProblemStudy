package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac1016;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int a[] = new int[N];
    static int f[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
            f[i] = a[i];
        }
        for(int i = 1; i <= n; i ++) {
            for (int j = 1; j < i; j ++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + a[i]);
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
