package com.lxhcaicai.algorithm.graphTheory.shortestPath.ac1126;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int N = (int) (2E5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static double[] edge = new double[N];
    static int tot = 0;
    static void addedge(int x, int y, double z) {
        ver[ ++ tot] = y;
        nex[tot] = head[x];
        edge[tot] = z;
        head[x] = tot;
    }

    static boolean vis[] = new boolean[N];
    static double dis[] = new double[N];

    static final double eps = 1e-8;

    static class Node implements Comparable<Node> {
        int x;
        double dis;

        @Override
        public int compareTo(Node o) {
            if(Math.abs(dis - o.dis) < eps) {
                return 0;
            } else if(dis > o.dis) {
                return -1;
            } else {
                return 1;
            }
        }

        public Node(int x, double dis) {
            this.x = x;
            this.dis = dis;
        }
    }

    static void dijkstra(int st) {
        Arrays.fill(vis, false);
        Arrays.fill(dis, 0);
        dis[st] = 1;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, dis[st]));
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(dis[y] < dis[x] * edge[i]) {
                    dis[y] = dis[x] * edge[i];
                    queue.add(new Node(y, dis[y]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, 1 - 0.01 * z);
            addedge(y,x, 1 - 0.01 * z);
        }
        int st = scanner.nextInt();
        int ed = scanner.nextInt();
        dijkstra(st);
        System.out.printf("%.8f",100 / dis[ed]);
    }
}
