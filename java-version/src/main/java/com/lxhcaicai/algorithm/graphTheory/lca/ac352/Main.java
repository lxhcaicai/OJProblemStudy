package com.lxhcaicai.algorithm.graphTheory.lca.ac352;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static final int N = 200010;
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;
    static void addedge(int x, int y) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int t;

    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));
    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }

    static int[][]f = new int[N][30];
    static int[] dep = new int[N];
    static void dfs(int x, int fa) {
        dep[x] = dep[fa] + 1;
        f[x][0] = fa;
        for(int i = 1; i <= t; i ++) {
            f[x][i] = f[f[x][i-1]][i-1];
        }
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (fa == y) {
                continue;
            }
            dfs(y,x);
        }
    }

    static int lca(int x,int y) {
        if (dep[x] > dep[y]) {
            int t = x;
            x = y;
            y = t;
        }

        for(int i = t; i >= 0; i --) {
            if (dep[f[y][i]] >= dep[x]) {
                y = f[y][i];
            }
        }

        if (y == x) {
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

    static int[] d = new int[N];

    static int ans = 0;
    static int n, m;

    static int dfs1(int x, int fa) {
        int res = d[x];
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (y == fa) {
                continue;
            }
            int s = dfs1(y, x);
            if (s == 0) {
                ans += m;
            } else if (s == 1) {
                ans ++;
            }
            res += s;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();
        t = (int) (Math.log(n) / Math.log(2) + 1);

        for(int i = 1; i < n; i ++) {
            int x = read();
            int y = read();
            addedge(x, y);
            addedge(y, x);
        }
        dfs(1, 0);

        for(int i = 1; i <= m; i ++) {
            int a = read();
            int b = read();
            int p = lca(a, b);
            d[a] ++;
            d[b] ++;
            d[p] -= 2;
        }

        dfs1(1, -1);
        System.out.println(ans);
    }
}
