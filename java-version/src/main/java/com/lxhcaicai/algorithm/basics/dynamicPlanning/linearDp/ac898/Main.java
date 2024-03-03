package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac898;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 510;
    static int[][] dp = new int[N][N];
    static int[][] a = new int[N][N];
    static int INF = (int) 1e7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for(int i = 1; i <= n; i ++) {
            Arrays.fill(dp[i], -INF);
        }
        dp[1][1] = a[1][1];
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + a[i][j];
            }
        }
        int ans = dp[n][1];
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
