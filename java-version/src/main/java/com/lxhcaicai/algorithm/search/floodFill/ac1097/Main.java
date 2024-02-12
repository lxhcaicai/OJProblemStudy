package com.lxhcaicai.algorithm.search.floodFill.ac1097;

import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int n, m;
    static String[] g = new String[N];

    static boolean[][] vis = new boolean[N][N];

    static void dfs(int i, int j) {
        if (0 <= i && i < n && 0 <= j && j < m && g[i].charAt(j) == 'W' && !vis[i][j]) {
            vis[i][j] = true;
            dfs(i + 1, j);dfs(i - 1, j);
            dfs(i, j + 1);dfs(i, j - 1);
            dfs(i + 1, j + 1);dfs(i - 1, j + 1);
            dfs(i + 1, j - 1);dfs(i - 1, j - 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i ++) {
            g[i] = scanner.next();
        }
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if (g[i].charAt(j)  == 'W' && !vis[i][j]) {
                    ans ++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }
}
