package com.lxhcaicai.algorithm.DP.digitalTriangleModel.ac1015;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1005;

    static int t;

    static int[][] a = new int[N][N];
    static int[][] f = new int[N][N];
    static Scanner scanner = new Scanner(System.in);

    static void solve(int n, int m) {
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for(int i = 1; i <= n; i ++) {
            Arrays.fill(f[i],0);
        }
        for(int i = 1; i <= n;  i ++) {
            for (int j = 1; j <=  m; j ++) {
                f[i][j] = Math.max(f[i][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
            }
        }
        System.out.println(f[n][m]);
    }

    public static void main(String[] args) {

        for(t = scanner.nextInt(); t > 0; t --) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
//            System.out.println(n + " --- " + m);
            solve(n, m);
        }
    }
}
