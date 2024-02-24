package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.bellmanFord.ac853;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int n, m;
    static final int INF = 0x3f3f3f3f;

    static class Edge {
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Edge[] edges = new Edge[N];

    static void copy(int[] a, int[] b) {
        for(int i = 1; i <= n; i ++) {
            a[i] = b[i];
        }
    }

    static int[] dis = new int[N];
    static int[] last = new int[N];

    static void bellmanFord(int k) {
        Arrays.fill(dis, INF);
        dis[1] = 0;
        for(int i = 0; i < k; i ++) {
            copy(last, dis);
            for(int j = 1; j <= m; j ++) {
                int x = edges[j].x;
                int y = edges[j].y;
                int z = edges[j].z;
                dis[y] = Math.min(dis[y], last[x] + z);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edges[i] = new Edge(x, y, z);
        }

        bellmanFord(k);
        if (dis[n] > INF/ 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dis[n]);
        }
    }
}
