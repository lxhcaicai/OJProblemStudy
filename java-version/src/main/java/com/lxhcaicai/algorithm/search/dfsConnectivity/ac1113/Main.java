package com.lxhcaicai.algorithm.search.dfsConnectivity.ac1113;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 30;
    static int n, m;
    static int[][]  vis = new int[N][N];
    static char[][] ss = new char[N][N];

    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {1, -1, 0, 0};

    static boolean isok(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m && ss[x][y] != '#';
    }

    static void dfs(int x, int y) {
        vis[x][y] = 1;
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y +dy[i];
            if (!isok(nx, ny)) {
                continue;
            }
            if (vis[nx][ny] != 0) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            for(int i = 1; i <= n; i ++) {
                Arrays.fill(vis[i], 0);
            }
            int x = 0, y = 0;
            for(int i = 1;  i<= n; i ++) {
                String str = scanner.next();
                for(int j = 0; j < m; j ++) {
                    ss[i][j + 1] = str.charAt(j);
                    if (str.charAt(j) == '@') {
                        x = i;
                        y = j + 1;
                    }
                }
            }
            dfs(x, y);
            int ans = 0;
            for(int i = 1; i <= n; i ++) {
                for(int j = 1; j <= m; j ++) {
                    ans += vis[i][j];
                }
            }
            System.out.println(ans);
        }
    }
}
