package com.lxhcaicai.algorithm.graphTheory.lca.ac356;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static int INF = 0x3f3f3f3f;
    static final int M = (int) (6E5 + 100);
    static final int N = (int) (1E5 + 100);
    static int[] head = new int[M];
    static int[] ver = new int[M];
    static int[] nex = new int[M];
    static int[] edge = new int[M];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static class Edge {
        int x, y, z;
        boolean flag;

        public Edge(int x, int y, int z, boolean flag) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.flag = flag;
        }
    }

    static Edge[] edges = new Edge[M];

    static int[] fa = new int[N];

    static int find(int x) {
        if(x == fa[x]) {
            return x;
        }
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static int n, m;

    static long kruskal() {
        Arrays.sort(edges, 1, 1 + m, (a,b)->(a.z-b.z));
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        long sum = 0;
        int cnt = 0;
        for(int i = 1; i <= m; i ++) {
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if (x != y) {
                edges[i].flag = true;
                sum += edges[i].z;
                fa[x] = y;
                cnt ++;
            }
            if (cnt == n - 1) {
                break;
            }
        }
        return sum;
    }

    static void build() {
        for(int i = 1; i <= m; i ++) {
            if (edges[i].flag) {
                int x = edges[i].x;
                int y = edges[i].y;
                int z = edges[i].z;
                addedge(x, y, z);
                addedge(y, x,z);
            }
        }
    }

    static int[] dep = new int[N];
    static int[][] f = new int[N][30];

    static int[][] dis1 = new int[N][30];
    static int[][] dis2 = new int[N][30];
    static void dfs(int x, int fa,int now) {
        dis1[x][0] = now;
        dis2[x][0] = -INF;
        dep[x] = dep[fa] + 1;
        f[x][0] = fa;
        for(int i = 1; i <= 16; i ++) {
            f[x][i] = f[f[x][i-1]][i-1];

            int distance[] = {dis1[x][i-1], dis2[x][i-1], dis1[f[x][i-1]][i-1],dis2[f[x][i-1]][i-1]};
            dis1[x][i] = dis2[x][i] = - INF;

            for(int j = 0; j < 4; j ++) {
                int d = distance[j];
                if (d > dis1[x][i]) {
                    dis2[x][i] = dis1[x][i];
                    dis1[x][i] = d;
                } else if (d != dis1[x][i] && d > dis2[x][i]) {
                    dis2[x][i] = d;
                }
            }
        }

        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (y == fa) {
                continue;
            }
            dfs(y, x, edge[i]);
        }
    }

    static int[] distance = new int[N];
    static int lca(int x, int y, int w) {
        int cnt = 0;
        if (dep[x] > dep[y]) {
            int temp = y;
            y = x;
            x = temp;
        }

        for(int i = 16; i >= 0; i --) {
            if (dep[f[y][i]] >= dep[x]) {
                distance[++cnt] = dis1[y][i];
                distance[++cnt] = dis2[y][i];
                y = f[y][i];
            }
        }

        if (x!=y) {
            for(int i = 16; i >= 0; i --) {
                if (f[y][i] != f[x][i]) {
                    distance[++cnt] = dis1[y][i];
                    distance[++cnt] = dis2[y][i];
                    distance[++cnt] = dis1[x][i];
                    distance[++cnt] = dis2[x][i];
                    y = f[y][i];
                    x = f[x][i];
                }
            }

            distance[++cnt] = dis1[x][0];
            distance[++cnt] = dis1[x][0];
        }
        int dist1 = -INF, dist2 = - INF;
        for(int i = 1; i <= cnt; i ++) {
            int d = distance[i];
            if (d > dist1) {
                dist2 = dist1;
                dist1 = d;
            } else if (d != dist1 && d > dist2) {
                dist2 = d;
            }
        }
        if ( w > dist1) {
            return w - dist1;
        }
        if (w > dist2) {
            return  w - dist2;
        }
        return  INF; // 基本不会出现
    }

    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));
    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }


    public static void main(String[] args) throws IOException {
        n =read();
        m = read();

        for(int i = 1; i <= m; i ++) {
            int x = read(), y = read(), z = read();
            edges[i] = new Edge(x, y,z,false);
        }

        long sum = kruskal();
        build();

        dfs(1,0,0);

        long res = (long) 1e18;
        for(int i = 1; i <= m; i ++) {
            if (!edges[i].flag) {
                int x = edges[i].x;
                int y = edges[i].y;
                int z = edges[i].z;
                res = Math.min(res, sum + lca(x, y,z));
            }
        }
        System.out.println(res);
    }

}
