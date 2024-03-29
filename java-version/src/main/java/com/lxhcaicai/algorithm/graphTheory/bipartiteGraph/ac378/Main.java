package com.lxhcaicai.algorithm.graphTheory.bipartiteGraph.ac378;

import java.util.Scanner;

public class Main {

    static final int N = 110;
    static int n, m, T;
    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] g = new boolean[N][N];
    static Pair[][] match = new Pair[N][N];

    static int cnt = 0;

    static int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
    static int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};

    static boolean isok(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }

    static int[][] vis = new int[N][N];
    static boolean dfs(int x, int y){
        for(int i = 0; i < 8; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isok(nx,ny)) {
                continue;
            }
            if (vis[nx][ny] == cnt || g[nx][ny]) {
                continue;
            }
            vis[nx][ny] = cnt;
            Pair t = match[nx][ny];
            if (t.x == -1 || dfs(t.x, t.y)) {
                match[nx][ny] = new Pair(x, y);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        T = scanner.nextInt();

        for(int i = 1; i <= T; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x][y] = true;
            g[x][y] = true;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                match[i][j] = new Pair(-1, 1);
            }
        }

        int res = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if (g[i][j] || (i +j) % 2 == 1) {
                    continue;
                }
                cnt ++;
                if (dfs(i, j)) {
                    res ++;
                }
            }
        }
        System.out.println(n * m - res - T);
    }
}
