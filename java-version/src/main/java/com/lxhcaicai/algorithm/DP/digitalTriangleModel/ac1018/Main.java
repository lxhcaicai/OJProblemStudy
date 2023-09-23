package com.lxhcaicai.algorithm.DP.digitalTriangleModel.ac1018;

import java.util.Arrays;
import java.util.Scanner;

// AcWing 1018最低通行费
public class Main {
    static final int N = 105;
    static int a[][] = new int[N][N];
    static int f[][] = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], N *N);
        }
        f[1][1] = a[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + a[i][j];
            }
        }
        System.out.println(f[n][n]);
    }
}
