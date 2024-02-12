package com.lxhcaicai.algorithm.search.floodFill.ac1098;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 100;

    static int[][] g = new int[N][N];

    static int n, m;
    static final int dx[] = {0, -1, 0, 1};
    static final int dy[] = {-1, 0, 1, 0};

    static boolean isOk(int x, int y) {
        return 1 <= x && x<= n && 1 <= y && y <= m;
    }

    static boolean[][] vis = new boolean[N][N];

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y) {
        int area = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        while (queue.size() > 0) {
            Pair no = queue.peek(); queue.poll();
            x = no.x;
            y = no.y;
            if (vis[x][y]) {
                continue;
            }
            vis[x][y] = true;
            area ++;
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isOk(nx, ny)) {
                    continue;
                }
                if ((g[x][y] >> i & 1) == 1) {
                    continue;
                }
                queue.add(new Pair(nx, ny));
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                g[i][j] = scanner.nextInt();
            }
        }
        int ans = 0, area = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if (!vis[i][j]) {
                    ans ++;
                    area = Math.max(area, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
        System.out.println(area);
    }
}
