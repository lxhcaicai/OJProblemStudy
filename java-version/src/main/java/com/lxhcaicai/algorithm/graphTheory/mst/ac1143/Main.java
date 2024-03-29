package com.lxhcaicai.algorithm.graphTheory.mst.ac1143;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static final int N = 10010;
    static int[] fa = new int[N];
    static class Edge {
        int p, x, y, z;

        public Edge(int p, int x, int y, int z) {
            this.p = p;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int find(int x) {
        if(x == fa[x]) {
            return x;
        }
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static Edge[] edges = new Edge[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i <= m; i ++) {
            int p = scanner.nextInt();
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges[i] = new Edge(p, u,v,w);
        }
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        Arrays.sort(edges, 1, m + 1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.p == o2.p) {
                    return o1.z - o2.z;
                }
                return o1.p - o2.p;
            }
        });
        int ans = 0;
        for(int i = 1; i <= m; i ++) {
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if(x != y) {
                fa[x] = y;
                ans += edges[i].z;
            } else if (edges[i].p == 1) {
                ans += edges[i].z;
            }
        }
        System.out.println(ans);
    }
}
