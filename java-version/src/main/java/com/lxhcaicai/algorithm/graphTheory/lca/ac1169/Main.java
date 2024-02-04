package com.lxhcaicai.algorithm.graphTheory.lca.ac1169;

import java.util.Scanner;

public class Main {
    static final int N = (int) (1e5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;
    static void addedge(int x, int y) {
        ver[++ tot] = y; nex[tot] = head[x];
        head[x] = tot;
    }

    static int n;
    static int t;

    static int[][] f = new int[N][30];
    static int[] dep = new int[N];

    static void dfs(int x,int fa) {
        f[x][0] = fa;
        dep[x] = dep[fa] + 1;
        for(int i = 1; i <= t; i ++) {
            f[x][i] = f[f[x][i-1]][i-1];
        }
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (y == fa) {
                continue;
            }
            dfs(y, x);
        }
    }

    static int lca(int x, int y) {
        if (dep[x] > dep[y]) {
            int t = y;
            y = x;
            x = t;
        }
        for(int i = t; i >= 0; i --) {
            if (dep[f[y][i]] >= dep[x]) {
                y = f[y][i];
            }
        }

        if (y ==x) {
            return x;
        }

        for(int i = t; i >= 0; i --) {
            if (f[x][i] != f[y][i]) {
                x = f[x][i];
                y = f[y][i];
            }
        }
        return f[x][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int root = 0;
        t = (int) (Math.log(n) / Math.log(2) + 1);
        for(int i = 1; i <= n; i ++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (b == -1) {
                root = a;
                continue;
            }
            addedge(a, b);
            addedge(b,a);
        }
        dfs(root, 0);
        int m = scanner.nextInt();
        while(m -- != 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = lca(x, y);
            if (x == z) {
                System.out.println(1);
            } else if (y == z) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}
