package com.lxhcaicai.algorithm.DP.knapsackModel.ac8;

import java.util.Scanner;

public class Main {
    static final int N = 110;
    static int[][] dp = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int M = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            int m = scanner.nextInt();
            int w = scanner.nextInt();
            for (int j = V; j >= v; j --) {
                for (int k = M; k >= m; k --) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-v][k-m] + w);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= V; i ++) {
            for (int j = 0; j <= M; j ++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
