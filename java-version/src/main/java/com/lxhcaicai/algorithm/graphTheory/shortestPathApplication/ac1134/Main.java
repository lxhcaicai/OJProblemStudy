package com.lxhcaicai.algorithm.graphTheory.shortestPathApplication.ac1134;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int MOD = 100003;
    static final int N = (int) (4e5 + 100);
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];

    static int tot = 0;
    static void addedge(int x, int y) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

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

    static int[] dis = new int[N];
    static int[] cnt = new int[N];
    static boolean[] vis = new boolean[N];

    static void dijkstra(int s) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(dis[s], s));
        Arrays.fill(cnt, 0);
        cnt[s] = 1;
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0;i = nex[i]) {
                int y =ver[i];
                if(dis[y] > dis[x] + 1) {
                    dis[y] = dis[x] + 1;
                    cnt[y] = cnt[x];
                    queue.add(new Node(dis[y], y));
                } else if(dis[y] == dis[x] + 1){
                    cnt[y] = (cnt[x] + cnt[y]) % MOD;
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
            addedge(x, y);
            addedge(y, x);
        }
        dijkstra(1);
        for(int i = 1; i <= n; i ++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(cnt[i]);
            }
        }
    }
}
