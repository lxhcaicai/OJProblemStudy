package com.lxhcaicai.algorithm.DP.digitalTriangleModel.ac275;

import java.util.Scanner;

public class Main {

    static final int N = 55;
    static int a[][] = new int[N][N];
    static int f[][][] = new int[2 * N][N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for(int k = 2; k <= n + m; k ++) {
            for(int i1 = 1; i1 <= n; i1 ++) {
                for (int i2 = 1; i2 <= n; i2 ++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (1 <= j1 && j1 <=m && 1 <= j2 && j2 <=m ) {
                        int w = a[i1][j1];
                        if (i1 != i2) {
                            w += a[i2][j2];
                        }
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k-1][i1-1][i2] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k-1][i1][i2-1] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k-1][i1-1][i2-1] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k-1][i1][i2] + w);
                    }
                }
            }
        }

        System.out.println(f[n + m][n][n]);
    }
}
