package com.lxhcaicai.algorithm.graphTheory.shortestPathApplication.ac383;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int N = (int) (1e5 + 100);
    static final int INF = 0X3F3F3F3F;
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];
    static int tot = 0;
    static void addedege(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static int[][] cnt = new int[N][2];
    static int[][] dis = new int[N][2];
    static boolean[][] vis = new boolean[N][2];

    static class Node implements Comparable<Node>{
        int x, type, dis;

        public Node(int x, int type, int dis) {
            this.x = x;
            this.type = type;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }

    static int dijkstra(int st, int ed) {
        for(int i = 0; i < N; i ++) {
            Arrays.fill(vis[i], false);
            Arrays.fill(dis[i], INF);
            Arrays.fill(cnt[i], 0);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dis[st][0] = 0;
        cnt[st][0] = 1;
        queue.add(new Node(st, 0, 0));

        while(queue.size() > 0) {
            Node no = queue.peek();
            queue.poll();

            int x = no.x;
            int type = no.type;
            if(vis[x][type]) {
                continue;
            }
            vis[x][type] = true;

            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(dis[y][0] > dis[x][type] + edge[i]) {
                    dis[y][1] = dis[y][0];
                    cnt[y][1] = cnt[y][0];
                    queue.add(new Node(y, 1, dis[y][1]));

                    dis[y][0] = dis[x][type] + edge[i];
                    cnt[y][0] = cnt[x][type];
                    queue.add(new Node(y, 0, dis[y][0]));
                } else if (dis[y][0] == dis[x][type] + edge[i]) {
                    cnt[y][0] += cnt[x][type];
                } else if (dis[y][1] > dis[x][type] + edge[i]) {
                    dis[y][1] = dis[x][type] + edge[i];
                    cnt[y][1] = cnt[x][type];
                    queue.add(new Node(y, 1, dis[y][1]));
                } else if (dis[y][1] == dis[x][type] + edge[i]) {
                    cnt[y][1] += cnt[x][type];
                }
            }

        }

        int res = cnt[ed][0];
        if(dis[ed][0] + 1 == dis[ed][1]) {
            res += cnt[ed][1];
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T -- != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Arrays.fill(head, 0);
            tot = 0;
            for(int i = 1; i <= m; i ++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                addedege(x, y, z);
            }
            int s = scanner.nextInt();
            int f = scanner.nextInt();
            System.out.println(dijkstra(s, f));
        }
    }
}
