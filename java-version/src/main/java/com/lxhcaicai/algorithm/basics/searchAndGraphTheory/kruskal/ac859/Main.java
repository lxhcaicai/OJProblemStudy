package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.kruskal.ac859;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (2e5 + 100);

    static class Edge {
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static Edge[] edges = new Edge[N];

    static int n, m;
    static int[] fa = new int[N];

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static String kruskal() {
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        int cnt = 0;
        int ans = 0;
        Arrays.sort(edges, 1, m + 1, ((o1, o2) -> (o1.z - o2.z)));
        for(int i = 1; i <= m; i ++) {
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if (x != y) {
                ans += edges[i].z;
                cnt ++;
                fa[x] = y;
            }
            if(cnt == n - 1) {
                break;
            }
        }

        if (cnt != n - 1) {
            return "impossible";
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edges[i] = new Edge(x, y, z);
        }
        System.out.println(kruskal());
    }
}
