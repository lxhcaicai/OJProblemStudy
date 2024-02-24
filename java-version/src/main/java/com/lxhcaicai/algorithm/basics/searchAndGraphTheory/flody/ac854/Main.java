package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.flody.ac854;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 210;
    static final int INF = 0x3f3f3f3f;
    static int[][] dis = new int[N][N];

    static int n;
    static int m;


    static void flody() {
        for(int k = 1; k <= n; k ++) {
            for(int i = 1; i <= n; i ++) {
                for(int j = 1; j <= n; j ++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int Q = scanner.nextInt();
        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ ) {
                if (i == j) dis[i][j] = 0;
                else dis[i][j] = INF;
            }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            dis[x][y] = Math.min(dis[x][y], z);
        }
        flody();
        while (Q -- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (dis[x][y] >= INF / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(dis[x][y]);
            }
        }
    }
}
