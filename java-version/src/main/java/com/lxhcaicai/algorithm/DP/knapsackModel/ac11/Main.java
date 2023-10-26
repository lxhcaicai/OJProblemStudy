package com.lxhcaicai.algorithm.DP.knapsackModel.ac11;

import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static final int MOD = (int) (1E9 + 7);
    static int[] f = new int[N];
    static int[] dp = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            for (int j = m; j >= v; j --) {
                if (f[j] < f[j - v] + w) {
                    f[j] = f[j - v] + w;
                    dp[j] = dp[j -v];
                } else if (f[j] == f[j - v] + w){
                    dp[j] = (dp[j] + dp[j - v]) % MOD;
                }
            }
        }
        int ans = 0, res = 0;
        for (int i = 0; i <= m; i ++) {
            if (ans < f[i]) {
                res = dp[i];
                ans = f[i];
            } else if (ans == f[i]) {
                res = (res +dp[i]) % MOD;
            }
        }
        System.out.println(res);
    }
}
