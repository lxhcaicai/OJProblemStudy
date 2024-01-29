package com.lxhcaicai.algorithm.graphTheory.shortestPath.ac1128;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// AcWing 1128. 信使
public class Main {
    public static final int N = 110;
    public static final int M = 210;

    public static int head[] = new int[N];
    public static int edge[] = new int[M * 2];
    public static int ver[] = new int[M * 2];
    public static int nex[] = new int[M * 2];
    public static int tot = 0;

    static void addedge(int x,int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

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

    static boolean vis[] = new boolean[N];
    static int dis[] = new int[N];

    static int dijkstra(int st, int n) {
        Arrays.fill(vis, false);
        Arrays.fill(dis,Integer.MAX_VALUE);
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
            for(int i = head[x]; i !=0; i = nex[i]) {
                int y = ver[i];
                if (dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    queue.add(new Node(y, dis[y]));
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(ans, dis[i]);
        }

        if (ans == Integer.MAX_VALUE) {
            return  -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 0; i < m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            addedge(y,x,z);
        }
        System.out.println(dijkstra(1, n));
    }

}
