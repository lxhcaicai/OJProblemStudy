package com.lxhcaicai.algorithm.graphTheory.mst.ac1145;

import java.util.*;

public class Main {
    static final int N = 600;
    static final int M = N * N;
    static final double eps = 1e-8;
    static int n, m, k;

    static int fa[] = new int[N];

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static class  Edge implements Comparable<Edge> {
        int x, y;
        double dis;

        @Override
        public int compareTo(Edge o) {
            if(Math.abs(dis - o.dis) < eps) return 0;
            else {
                if(dis > o.dis) return 1;
                else return -1;
            }
        }

        public Edge(int x, int y, double dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static Edge[] edges = new Edge[M];

    static double kruskal() {
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        Arrays.sort(edges, 1, m + 1);
        int cnt = 0;
        for(int i = 1; i <= m; i ++) {
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if (x != y) {
                fa[x] = y;
                cnt ++;
                if(cnt == n - k) {
                    return edges[i].dis;
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<Node> list = new ArrayList<>();
    static double cal(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) +(y1 -  y2) *(y1 -  y2));
    }
    static void build() {
        int tot = 0;
        for(int i = 0; i < list.size(); i ++) {
            Node node = list.get(i);
            int x1 = node.x;
            int y1 = node.y;
            for(int j = i + 1; j < list.size(); j ++) {
                Node no = list.get(j);
                int x2 = no.x;
                int y2 = no.y;
                double dis = cal(x1, y1, x2, y2);
                edges[ ++ tot] = new Edge(i + 1, j + 1, dis);
            }
        }
        m = tot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        if(k == 0) {
            k = 1;
        }
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Node(x,y));
        }
        build();;
        System.out.printf("%.2f", kruskal());
    }
}
