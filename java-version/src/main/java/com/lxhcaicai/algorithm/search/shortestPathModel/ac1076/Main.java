package com.lxhcaicai.algorithm.search.shortestPathModel.ac1076;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 1010;

    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {1, -1, 0, 0};

    static int n;
    static boolean[][] vis = new boolean[N][N];
    static int[][] g = new int[N][N];

    static boolean isok(int x, int y) {
        return  0 <= x && x < n && 0 <= y && y < n && g[x][y] == 0;
    }

    static Pair[][] p = new Pair[N][N];

    static class Pair{
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n - 1, n -1));
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                p[i][j] = new Pair(-1,-1);
            }
        }
        while (queue.size() > 0) {
            Pair no = queue.peek(); queue.poll();
            int x = no.x;
            int y = no.y;
            if (vis[x][y]) {
                continue;
            }
            vis[x][y] = true;
            if (x == 0 && y==0) {
                return;
            }
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isok(nx, ny)) {
                    continue;
                }
                if (p[nx][ny].x != -1) {
                    continue;
                }
                queue.add(new Pair(nx, ny));
                p[nx][ny] = new Pair(x, y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                g[i][j] = scanner.nextInt();
            }
        }
        bfs();
        Pair e = new Pair(0, 0);
        while (true) {
            System.out.println(e.x + " " + e.y);
            if (e.x == n - 1 && e.y == n - 1)  {
                break;
            }
            e = p[e.x][e.y];
        }
    }
}
