package com.lxhcaicai.algorithm.DP.knapsackModel.ac1013;

import java.util.Scanner;

public class Main {
    // AcWing 1013. 机器分配
    static final int N = 20;
    static int[][] f = new int[N][N];
    static int[][] w = new int[N][N];
    static int[] way = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                w[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j <= m; j ++) {
                for (int k = 0; k <= j; k ++) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j-k] + w[i][k]);
                }
            }
        }

        System.out.println(f[n][m]);

        int j = m;
        for (int i = n; i > 0; i --) {
            for (int k = 0; k <= m; k ++) {
                if (f[i][j] == f[i-1][j - k] + w[i][k]) {
                    way[i] = k;
                    j -= k;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i ++) {
            System.out.printf("%d %d\n", i, way[i]);
        }
    }
}
