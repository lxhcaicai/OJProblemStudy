package com.lxhcaicai.algorithm.search.Aplus.ac178;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1E4 + 100);

    static int[] head1 = new int[N];
    static int[] head2 = new int[N];
    static int[] nex = new int[N << 1];
    static int[] edge = new int[N <<1];
    static int[] ver = new int[N <<1];
    static int tot = 0;
    static final int INF = 0x3f3f3f3f;
    static void addedge(int[] head, int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static int[] f = new int[N];

    static class Pair implements Comparable<Pair>{
        int x, dis;

        public Pair(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pair o) {
            return dis - o.dis;
        }
    }

    static boolean[] vis = new boolean[N];

    static void dijkstra(int s) {
        Arrays.fill(f, INF);
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(s, 0));
        f[s] = 0;
        while (queue.size() > 0) {
            int x = queue.peek().x;
            queue.poll();
            if (vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head2[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (f[y] > f[x] + edge[i]) {
                    f[y] = f[x] + edge[i];
                    queue.add(new Pair(y, f[y]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x, dist, w;

        @Override
        public int compareTo(Node o) {
            if (w == o.w) {
                return dist -o.dist;
            }
            return w -o.w;
        }

        public Node(int x, int dist, int w) {
            this.x = x;
            this.dist = dist;
            this.w = w;
        }
    }

    static int bfs(int s, int t, int k) {
        dijkstra(t);
        if (f[s] == INF) {
            return -1;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0, f[s] + 0));
        int cnt = 0;
        while (queue.size() > 0) {
            Node no = queue.peek();queue.poll();
            int x = no.x;
            int dist = no.dist;
            if (no.w >= INF) {
                return -1;
            }
            if (x == t) {
                cnt ++;
            }
            if (cnt >= k) {
                return dist;
            }
            for(int i = head1[x];i!=0; i = nex[i]) {
                int y = ver[i];
                queue.add(new Node(y, dist +edge[i], f[y] + dist + edge[i]));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x= scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(head1, x, y, z);
            addedge(head2, y, x, z);
        }
        int s =scanner.nextInt();
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        if (s == t) {
            k ++;
        }
        System.out.println(bfs(s, t, k));
    }
}
