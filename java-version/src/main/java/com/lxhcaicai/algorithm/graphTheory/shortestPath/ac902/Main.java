package com.lxhcaicai.algorithm.graphTheory.shortestPath.ac902;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int N = 250010;

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];

    static int tot = 0;
    static void addedge(int x, int y) {
        ver[ ++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] dis = new int[N];
    static boolean[] vis = new boolean[N];

    static class Node implements Comparable<Node>{
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

    static int dijkstra(int st, int ed) {
        Arrays.fill(dis,Integer.MAX_VALUE);
        Arrays.fill(vis, false);
        dis[st] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(dis[st],st));
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(dis[y] > dis[x] + 1) {
                    dis[y] = dis[x] + 1;
                    queue.add(new Node(dis[y], y));
                }
            }
        }
        if(dis[ed] == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return dis[ed] - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int c = 1; c <= m; c ++) {
            String[] ss = scanner.nextLine().split(" ");
            for(int i = 0; i < ss.length; i ++) {
                for(int j = i + 1; j < ss.length; j ++) {
                    int x = Integer.parseInt(ss[i]);
                    int y = Integer.parseInt(ss[j]);
                    addedge(x, y);
                }
            }
        }
        int ans = dijkstra(1, n);
        if (ans == Integer.MAX_VALUE) {
            System.out.println("NO");
        } else {
            System.out.println(ans);
        }
    }
}
