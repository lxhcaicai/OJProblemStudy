package com.lxhcaicai.algorithm.graphTheory.mst.ac1148;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int M = (int) (2e4 + 100);
    static final int N = 600;
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
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        Arrays.sort(edges, 1, m + 1, (a, b)->(a.z - b.z));

        long sum = 0;
        int cnt = 0;
        for(int i = 1; i <= m; i ++) {

            int x = edges[i].x;
            x = find(x);
            int y = edges[i].y;
            y = find(y);
            if(x != y) {
                fa[x] = y;
                sum += edges[i].z;
                edges[i].flag = true;
                cnt ++;
            }
            if(cnt == n - 1) break;
        }
        return sum;

    }


    static void build () {
        for(int i = 1; i <= m; i ++) {
            if(edges[i].flag) {
                int x = edges[i].x;
                int y = edges[i].y;
                int z = edges[i].z;
                addedge(x, y, z);
                addedge(y, x, z);
            }
        }
    }
    static int[][] dis1 = new int[N][N];
    static int[][] dis2 = new int[N][N];

    static void dfs(int st,int x, int fa, int max1, int max2) {
        dis1[st][x] = max1;
        dis2[st][x] = max2;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (y == fa) {
                continue;
            }
            if (edge[i] > max1) {
                dfs(st, y, x, edge[i], max1);             // 如果x -- y这条边大于 st -- x的最大边
            } else if (edge[i] < max1 && edge[i] > max2) {
                dfs(st, y, x, max1, edge[i]); // 如果x--y这条边小于st--x的最大边  但大于 st--x的次大边
            } else {
                dfs(st, y, x, max1, max2); // 当前边 x--y 去更新 st --y 的次大边
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edges[i] = new Edge(x, y, z, false);
        }

        long sum = kruskal();

        build();

        for(int i = 1; i <= n; i ++) {
            dfs(i, i, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        long ans = (long) 1e18;

        for(int i = 1; i <= m; i ++) {
            if(!edges[i].flag) {
                int x = edges[i].x;
                int y = edges[i].y;
                int z = edges[i].z;
                if(z > dis1[x][y]) {
                    ans = Math.min(ans, sum + z - dis1[x][y]);
                }
                else if(z > dis2[x][y]) {
                    ans = Math.min(ans, sum + z - dis2[x][y]);
                }
            }
        }

        System.out.println(ans);
    }
}
