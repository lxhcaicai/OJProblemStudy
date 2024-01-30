package com.lxhcaicai.algorithm.graphTheory.shortestPath.ac903;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int N = (int) (1e4 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        edge[tot] = z;
        head[x] = tot;
    }

    static int[] level = new int[N];

    static int[] dis = new int[N];
    static int n, m;
    static class Node implements Comparable<Node> {
        int dis;
        int x;

        public Node(int dis, int x) {
            this.dis = dis;
            this.x = x;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }
    static boolean[] vis  = new boolean[N];
    static void dijkstra(int L, int R) {
        Arrays.fill(vis, false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(dis[0], 0));
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y  = ver[i];
                if (L <= level[y] && level[y] <= R) {
                    if (dis[y] > dis[x] + edge[i]) {
                        dis[y] = dis[x] + edge[i];
                        queue.add(new Node(dis[y], y));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int P = scanner.nextInt();
            int L = scanner.nextInt();
            int num = scanner.nextInt();
            level[i] = L;
            addedge(0, i, P);
            for(int j = 1; j <= num; j ++) {
                int T = scanner.nextInt();
                int V = scanner.nextInt();
                addedge(T, i, V);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = level[1] - m; i <= level[1]; i ++) {
            dijkstra(i, i + m);
            ans = Math.min(ans, dis[1]);
        }
        System.out.println(ans);
    }
}
