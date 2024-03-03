package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac897;

import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int[][] f = new int[N][N];

    static String a;
    static String b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = scanner.next();
        b = scanner.next();
        a = " " + a;
        b = " " + b;

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if (a.charAt(i) == b.charAt(j)) {
                    f[i][j] = f[i-1][j-1] + 1;
                } else {
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
