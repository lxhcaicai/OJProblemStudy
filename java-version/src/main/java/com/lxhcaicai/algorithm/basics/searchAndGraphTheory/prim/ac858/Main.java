package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.prim.ac858;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 550;
    static int[] dis = new int[N];
    static int[][] g = new int[N][N];
    static final int INF = 0x3f3f3f3f;

    static boolean[] vis = new boolean[N];

    static int n,m;

    static int prime() {
        Arrays.fill(dis, INF);
        int res = 0;
        for(int i = 0; i < n; i ++) {
            int t = -1;
            for(int j = 1; j <= n; j ++) {
                if (!vis[j] && (t == -1 || dis[t] > dis[j])) {
                    t = j;
                }
            }

            if (i > 0 && dis[t] == INF) {
                return INF;
            }
            if (i > 0) {
                res += dis[t];
            }
            vis[t] = true;

            for(int j = 1; j <= n; j ++) {
                dis[j] = Math.min(dis[j], g[t][j]);
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            Arrays.fill(g[i], INF);
        }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            g[x][y] = g[y][x] = Math.min(g[x][y], z);
        }

        int ans = prime();
        if (ans == INF ) {
            System.out.println("impossible");
        } else {
            System.out.println(ans);
        }
    }
}
