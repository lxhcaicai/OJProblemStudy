package com.lxhcaicai.algorithm.graphTheory.bipartiteGraph.ac376;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 110;
    static int[][] g = new int[N][N];
    static int[] match = new int[N];
    static int[] vis = new int[N];
    static int cnt = 0;
    static int n, m;

    static boolean dfs(int x) {
        for(int i = 1;  i<= m; i ++) {
            if (g[x][i] > 0) {
                if (vis[i] == cnt) {
                    continue;
                }
                vis[i] = cnt;
                if (match[i] == 0 || dfs(match[i])) {
                    match[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T;
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            m = scanner.nextInt();
            T = scanner.nextInt();
            for(int i = 0; i < N; i ++) {
                Arrays.fill(g[i], 0);
            }
            Arrays.fill(match, 0);
            while (T -- > 0) {
                int t = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x == 0 || y == 0) {
                    continue;
                }
                g[x][y] = 1;
            }
            int ans = 0;
            for(int i = 1; i <= n; i ++) {
                cnt ++;
                if (dfs(i)) {
                    ans ++;
                }
            }
            System.out.println(ans);
        }
    }

}
