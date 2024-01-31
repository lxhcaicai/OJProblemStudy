package com.lxhcaicai.algorithm.graphTheory.mst.ac1140;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 20000;

    static class Edge implements Comparable<Edge> {
        int x, y, z;

        @Override
        public int compareTo(Edge o) {
            return z -o.z;
        }

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Edge[] edges = new Edge[N];
    static int[] fa = new int[N];
    static int find(int x) {
        if(x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = n * n;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                int z = scanner.nextInt();
                edges[n * (i - 1) + j] = new Edge(i, j, z);
            }
        }
        Arrays.sort(edges, 1, 1 + m);
        int cnt = 0;
        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        for(int i = 1; i <= m; i ++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int z = edges[i].z;
            x = find(x);
            y = find(y);
            if (x != y) {
                cnt ++;
                ans += z;
                fa[x] = y;
            }
            if(cnt == n - 1) {
                break;
            }
        }
        System.out.println(ans);
    }
}
