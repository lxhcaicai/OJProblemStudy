package com.lxhcaicai.algorithm.graphTheory.mst.ac1142;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static final int N = 10000;

    static int[] fa = new int[N];

    static class Edge{
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static Edge[] edges = new Edge[N];

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
        int m = scanner.nextInt();
        for(int i = 1;  i<= n; i ++) {
            fa[i] = i;
        }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edges[i] = new Edge(x, y, z);
        }
        Arrays.sort(edges, 1, 1 + m, new Comparator<Edge>() {

            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.z - o2.z;
            }
        });
        int ans = 0;
        int cnt = 0;
        for(int i = 1; i <= m; i ++) {
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if(x != y) {
                cnt ++;
                fa[x] = y;
                ans = edges[i].z;
            }
            if(cnt == n - 1) {
                break;
            }
        }
        System.out.printf("%d %d", n - 1, ans);
    }
}
