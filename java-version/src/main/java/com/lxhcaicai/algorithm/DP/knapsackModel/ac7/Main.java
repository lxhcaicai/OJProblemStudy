package com.lxhcaicai.algorithm.DP.knapsackModel.ac7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1010;
    static int[] dp = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int s = scanner.nextInt();
            if (s == -1) {
                for (int j = m; j >= v; j --) {
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            } else if (s == 0) {
                for (int j = v; j <= m; j ++) {
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            } else {
                for (int k = 1; k <= s;k <<= 1) {
                    for (int j = m; j >= k*v; j --) {
                        dp[j] = Math.max(dp[j], dp[j - k*v] + k*w);
                    }
                    s -= k;
                }
                if (s > 0) {
                    for (int j = m; j >= s*v; j --) {
                        dp[j] = Math.max(dp[j], dp[j - s*v] + s*w);
                    }
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
