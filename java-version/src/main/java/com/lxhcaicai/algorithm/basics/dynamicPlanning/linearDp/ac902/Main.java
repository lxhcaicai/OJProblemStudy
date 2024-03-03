package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac902;

import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int[][] f = new int[N][N];

    static String a;
    static String b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = scanner.next();
        int m = scanner.nextInt();
        b = scanner.next();
        a = " " + a;
        b = " " + b;
        for(int i = 1; i <= n; i ++) {
            f[i][0] = i;
        }
        for(int i = 1; i <= m; i ++) {
            f[0][i] = i;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] = Math.min(f[i][j-1], f[i-1][j]) + 1;
                if (a.charAt(i) == b.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }

        System.out.println(f[n][m]);
    }
}
