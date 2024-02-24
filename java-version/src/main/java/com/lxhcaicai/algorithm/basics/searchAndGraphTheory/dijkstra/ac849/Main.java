package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.dijkstra.ac849;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 510;
    static int[][] g = new int[N][N];
    static int[] dis = new int[N];
    static boolean[] vis = new boolean[N];
    static final int INF = 0x3f3f3f3f;

    static int n, m;

    static int dijkstra(int st) {
        Arrays.fill(dis, INF);
        dis[st] = 0;
        for(int i = 0; i < n; i ++) {
            int t = -1;
            for(int j = 1; j <= n; j ++) {
                if (!vis[j] && (t == -1 || dis[t] > dis[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for(int j = 1; j <= n; j ++) {
                dis[j] = Math.min(dis[j], dis[t] + g[t][j]);
            }
        }
        return dis[n] == INF? -1: dis[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <=n; i ++) {
            Arrays.fill(g[i], INF);
        }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            g[x][y] = Math.min(g[x][y], z);
        }

        System.out.println(dijkstra(1));
    }
}
