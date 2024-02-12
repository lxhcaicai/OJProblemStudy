package com.lxhcaicai.algorithm.search.floodFill.ac1106;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 1010;

    static boolean[][] vis = new boolean[N][N];

    static int n;

    static boolean isok(int x, int y) {
        return 1 <=x && x <= n && 1 <= y && y <= n;
    }

    static int[][] h = new int[N][N];

    static class Pair{
        int first, second;
        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(x, y));

        while(que.size() > 0) {
            Pair no = que.peek(); que.poll();
            x = no.first;
            y = no.second;
            if(vis[x][y]) continue;
            vis[x][y] = true;
            for(int nx = x - 1; nx <= x + 1; nx ++) {
                for(int ny = y - 1; ny <= y + 1; ny ++) {
                    if(nx == x && ny == y) continue;
                    if(!isok(nx, ny)) continue;
                    if(h[nx][ny] != h[x][y]) {
                        if(h[nx][ny] > h[x][y]) isHeight = false;
                        else isSlow = false;
                    }
                    else if (!vis[nx][ny]) {
                        que.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static boolean isHeight = false, isSlow = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                h[i][j] = scanner.nextInt();
            }
        }
        int ans = 0, res = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if (!vis[i][j]) {
                    isHeight = true;
                    isSlow = true;
                    bfs(i,j);
                    if (isHeight) {
                        ans ++;
                    }
                    if (isSlow) {
                        res ++;
                    }
                }
            }
        }
        System.out.println(ans + " " + res);
    }
}
