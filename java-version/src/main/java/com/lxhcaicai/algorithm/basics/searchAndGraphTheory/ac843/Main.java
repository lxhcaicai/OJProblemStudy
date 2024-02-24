package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.ac843;

import java.util.Scanner;

public class Main {

    static final int N = 20;
    static char[][] g = new char[N][N];

    static boolean[] col = new boolean[N];
    static boolean[] st1 = new boolean[N];
    static boolean[] st2 = new boolean[N];

    static int n;

    static void dfs(int d) {
        if (d > n) {
            for(int i = 1; i <= n; i ++) {
                for(int j = 1; j <= n; j ++) {
                    System.out.printf(String.valueOf(g[i][j]));
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i ++) {
            if (col[i] || st1[i + d] || st2[i - d + n]) {
                continue;
            }
            col[i] = st1[i + d] = st2[i - d + n] = true;
            g[d][i] = 'Q';
            dfs(d + 1);
            col[i] = st1[i + d] = st2[i - d + n] = false;
            g[d][i] = '.';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                g[i][j] = '.';
            }
        }
        dfs(1);
    }
}
