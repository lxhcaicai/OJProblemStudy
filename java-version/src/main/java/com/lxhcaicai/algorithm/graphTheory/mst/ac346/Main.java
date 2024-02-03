package com.lxhcaicai.algorithm.graphTheory.mst.ac346;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 10010;
    static int cnt[] = new int[N];
    static int fa[] = new int[N];

    static class Edge implements Comparable<Edge>{
        int x, y, z;

        @Override
        public int compareTo(Edge o) {
            return z - o.z;
        }

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static Edge[] edges = new Edge[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t -- != 0) {
            int n = scanner.nextInt();
            for(int i = 1; i <= n - 1; i ++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                edges[i] = new Edge(x, y, z);
            }
            for(int i = 1; i <= n; i ++) {
                fa[i] = i;
                cnt[i] = 1;
            }
            Arrays.sort(edges, 1, n);
            int ans = 0;
            for(int i = 1; i <= n - 1; i ++) {
                int x = find(edges[i].x);
                int y = find(edges[i].y);
                if (x != y) {
                   ans += (cnt[x] * cnt[y] - 1) * (edges[i].z + 1); // 出去最小生成树的边  边数*边权
                   fa[x] = y;
                   cnt[y] += cnt[x];
                }
            }
            System.out.println(ans);
        }

    }
}
