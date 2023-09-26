package com.lxhcaicai.algorithm.DP.digitalTriangleModel.ac1027;

import java.util.Scanner;

// AcWing 1027. 方格取数
public class Main {
    static final int N = 11;
    static int f[][][] = new int[2 * N][N][N];
    static int a[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x == 0 && y ==0 && z == 0) {
                break;
            }
            a[x][y] = z;
        }

        for(int k = 2; k <= 2 * n; k ++) {
            for(int i1 = 1; i1 <= n; i1 ++) {
                for(int i2 = 1; i2 <= n; i2 ++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (1 <= j1 && j1 <= n && 1 <= j2 && j2 <= n) {
                        int w = a[i1][j1];
                        if (i1 != i2) {
                            w += a[i2][j2];
                        }
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1-1][i2-1] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1][i2-1] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1-1][i2] + w);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1][i2] + w);
                    }
                }
            }
        }

        System.out.println(f[2 * n][n][n]);
    }
}
