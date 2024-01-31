package com.lxhcaicai.algorithm.graphTheory.shortestPathApplication.ac340;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e6 + 100);
    static int head[] = new int[N];
    static int nex[] = new int[N];
    static int edge[] = new int[N];
    static int ver[] = new int[N];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static boolean vis[] = new boolean[N];
    static int dis[] = new int[N];

    static class Node implements Comparable<Node> {
        int x;
        int dis;

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }

        public Node(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }
    }

    static void dijkstra(int st) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[st] = 0;
        Arrays.fill(vis, false);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, dis[st]));
        while(queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                int maxn = Math.max(edge[i], dis[x]);
                if (dis[y] > maxn) {
                    dis[y] = maxn;
                    queue.add(new Node(y, dis[y]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            addedge(y, x, z);
            for(int j = 1; j <= k; j ++) {
                addedge(x + (j - 1) * n, y + j * n, 0);
                addedge(y + (j - 1) * n, x + j * n, 0);
                addedge(x + n * j, y+ n * j, z);
                addedge(y+ n * j, x+ n * j, z);
            }
        }

        if(m <= k) {
            System.out.println(0);
            return;
        }
        dijkstra(1);
        if (dis[(k +1 ) * n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dis[(k +1 ) * n]);
        }
    }
}
