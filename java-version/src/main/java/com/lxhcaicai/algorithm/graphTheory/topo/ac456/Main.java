package com.lxhcaicai.algorithm.graphTheory.topo.ac456;

import java.util.*;

public class Main {

    static final int N = 2010;
    static final int M = (int) (1E6 + 10);

    static int n, m;
    static int[] head = new int[N];
    static int[] edge = new int[M];
    static int[] nex = new int[M];
    static int[] ver = new int[M];
    static int tot = 0;
    static boolean[] st = new boolean[N];
    static int[] deg = new int[N];
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
        deg[y] ++;
    }

    static List<Integer> list = new ArrayList<>();
    static int cnt = 0;

    static void topo() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n + m; i ++) {
            if(deg[i] == 0) {
                queue.add(i);
            }
        }

        while(queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            list.add(x);
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if(-- deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }

    static int[] dist = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(head, 0);
        for(int i = 1; i <= m; i ++){
            Arrays.fill(st, false);
            int cnt = scanner.nextInt();
            int start = n, end = 1;
            while (cnt -- > 0) {
                int stop = scanner.nextInt();
                start = Math.min(start, stop);
                end= Math.max(end, stop);
                st[stop] = true;
            }

            int v = n + i; // 虚拟点
            for(int j = start; j <= end; j ++) {
                if (!st[j]) {
                    addedge(j ,v,0);
                } else {
                    addedge(v, j, 1);
                }
            }
        }

        topo();
        for(int i = 1; i <= n; i ++) {
            dist[i] = 1;
        }
        list.forEach(x -> {
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                dist[y] = Math.max(dist[y], dist[x] + edge[i]);
            }
        });

        int res = 0;
        for(int i = 1; i <= n; i ++) {
            res = Math.max(res, dist[i]);
        }

        System.out.println(res);
    }
}
