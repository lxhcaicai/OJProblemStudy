package com.lxhcaicai.algorithm.DP.knapsackModel.ac6;

import java.util.Arrays;
import java.util.Scanner;
// AcWing 6. 多重背包问题
public class Main {

    static final int N = 20010;

    static int []dp = new int[N];
    static int []pre = new int[N];
    static int []q = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            pre = Arrays.copyOfRange(dp, 0,N);
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int s = scanner.nextInt();
            for(int j = 0; j < v; j ++) {
                int head = 0;
                int tail = -1;
                for (int k = j; k <= m; k += v) {
                    if (head <= tail && k - s * v > q[head]) {
                        head++;
                    }
                    while (head <= tail && pre[q[tail]] - (q[tail] - j)/v * w <= pre[k] - (k - j)/v * w) {
                        tail--;
                    }
                    if (head <= tail) {
                        dp[k] = pre[q[head]] + (k - q[head]) / v * w;
                    }
                    q[++tail] = k;
                }
            }
        }
        System.out.println(dp[m]);
    }
}
