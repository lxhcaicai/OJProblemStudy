package com.lxhcaicai.algorithm.graphTheory.shortestPathApplication.ac342;

import java.util.*;

public class Main {
    static final int N = (int) (1e6 + 100);
    static final int INF = 0x3f3f3f3f;
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];

    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
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
    static boolean[] vis = new boolean[N];
    static int cnt = 0;
    static int color[] = new int[N];
    static List<Integer>[] lists = new List[N];
    static void dfs(int x) {
        color[x] = cnt;
        lists[cnt].add(x);
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if(color[y] == 0) {
                dfs(y);
            }
        }
    }

    static void dijkstra(int t) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int x: lists[t]) {
            queue.add(new Node(dis[x], x));
        }
        while (queue.size()>0) {
            int x = queue.peek().x;
            queue.poll();
            if(vis[x]) {
                continue;
            }
            vis[x] = true;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    if(color[x] == color[y]) {
                        queue.add(new Node(dis[y], y));
                    }
                }
                if(color[x] != color[y]) {
                    if(-- deg[color[y]] == 0) {
                        que.add(color[y]);
                    }
                }
            }
        }
    }

    static int deg[] = new int[N];
    static Queue<Integer> que = new LinkedList<>();
    static void topo(int s) {
        for(int i = 1; i <= cnt; i ++) {
            if(deg[i] == 0) {
                que.add(i);
            }
        }
        dis[s] = 0;
        while(que.size() > 0) {
            int i = que.peek();
            que.poll();
            dijkstra(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int R = scanner.nextInt();
        int P = scanner.nextInt();
        int S = scanner.nextInt();
        for(int i = 1;  i <= R; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            addedge(y, x, z);
        }
        for(int i = 1 ; i <= T; i ++) {
            if(color[i] == 0) {
                cnt ++;
                lists[cnt] = new LinkedList<>();
                dfs(i);
            }
        }
        for(int i = 1; i <= P; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y , z);
            deg[color[y]] ++;
        }
        Arrays.fill(dis, INF);
        topo(S);

        for(int i = 1;  i<= T; i ++) {
            if(dis[i] >= INF / 2) {
                System.out.println("NO PATH");
            } else {
                System.out.println(dis[i]);
            }
        }
    }
}
