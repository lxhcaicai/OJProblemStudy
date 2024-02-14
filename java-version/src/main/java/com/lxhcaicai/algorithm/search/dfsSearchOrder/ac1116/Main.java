package com.lxhcaicai.algorithm.search.dfsSearchOrder.ac1116;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 30;

    static final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    static int n, m;

    static boolean isok(int x,int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static boolean[][] vis = new boolean[N][N];

    static int ans = 0;

    static void dfs(int x, int y, int cnt) {
        if(n * m == cnt) {
            ans ++;

            return;
        }

        for(int i = 0; i < 8; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isok(nx, ny)) continue;
            if(vis[nx][ny])continue;
            vis[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            vis[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(; T > 0; T --) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ans = 0;
            for(int i = 0; i < N; i ++) {
                Arrays.fill(vis[i], false);
            }
            vis[x][y] = true;
            dfs(x, y, 1);
            System.out.println(ans);
        }
    }
}
