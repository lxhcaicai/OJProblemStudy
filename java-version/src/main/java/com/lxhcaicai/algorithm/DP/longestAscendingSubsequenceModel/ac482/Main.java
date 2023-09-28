package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac482;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 110;
    static int a[] = new int[N];
    static int f[] = new int[N];
    static int g[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j < i; j ++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        for (int i = n; i >= 1; i --) {
            for (int j = n; j > i; j --) {
                if (a[i] > a[j]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            ans = Math.max(f[i] + g[i] - 1, ans);
        }
        System.out.println(n - ans);
    }
}
