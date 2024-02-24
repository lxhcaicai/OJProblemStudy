package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.dijkstra.ac850;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] head = new int[N];
    static int[] edge = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;

    static void addedge(int x, int y, int z) {
        ver[++tot] = y;
        nex[tot] = head[x];
        edge[tot] = z;
        head[x] = tot;
    }

    static int[] dis = new int[N];

    static class Node implements Comparable<Node> {
        int x, dis;

        public Node(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }


        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }

    static void dijkstra(int st) {
        boolean vis[] = new boolean[N];
        Arrays.fill(vis, false);
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[st] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, dis[st]));
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();

            if(vis[x]) continue;
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
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
            addedge(x, y, z);
        }
        dijkstra(1);
        System.out.println(dis[n] == Integer.MAX_VALUE? -1: dis[n]);
    }
}
