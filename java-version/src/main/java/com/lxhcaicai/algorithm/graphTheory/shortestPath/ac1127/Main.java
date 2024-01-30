package com.lxhcaicai.algorithm.graphTheory.shortestPath.ac1127;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// AcWing 1127. 香甜的黄油
public class Main {

    static final int N = 10000;

    static int head[] = new int[N];
    static int ver[] = new int[N];
    static int nex[] = new int[N];
    static int edge[] = new int[N];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static boolean vis[] = new boolean[N];
    static int dis[] = new int[N];

    static int cow[] = new int[N];

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

    static int dijkstra(int st, int n) {
        Arrays.fill(vis, false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[st] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, dis[st]));
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if (vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    queue.add(new Node(y, dis[y]));
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            int x = cow[i];
            if (dis[x] == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                ans += dis[x];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            cow[i] = scanner.nextInt();
        }
        for(int i = 1; i <= c; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            addedge(y, x,z);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= m; i ++) {
            ans = Math.min(ans, dijkstra(i, n));
        }
        System.out.println(ans);
    }
}
