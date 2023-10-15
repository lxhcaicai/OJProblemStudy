package com.lxhcaicai.algorithm.DP.knapsackModel.ac1020;

import java.util.Arrays;
import java.util.Scanner;
// AcWing 1020. 潜水员
public class Main {
    static final int N = 100;
    static int[][] dp = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i ++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        int k = scanner.nextInt();
        dp[0][0] = 0;
        for(int h = 1; h <= k; h ++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            for (int i = n; i >= 0; i --) {
                for (int j = m; j >= 0; j --) {
                    dp[i][j] = Math.min(dp[i][j], dp[Math.max(0, i - a)][Math.max(0, j - b)] + c);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
