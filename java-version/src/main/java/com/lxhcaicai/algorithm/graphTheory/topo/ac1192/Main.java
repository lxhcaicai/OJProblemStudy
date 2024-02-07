package com.lxhcaicai.algorithm.graphTheory.topo.ac1192;

import java.util.*;

public class Main {

    static final int N = 20100;
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y; nex[tot] = head[x];
        edge[tot] = z;
        head[x] = tot;
    }

    static int n,m;
    static int[] dis = new int[N];
    static int[] deg = new int[N];
    static void topo() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            if (deg[i] == 0) {
                queue.add(i);
                dis[i] = 100;
            }
        }
        while (queue.size() > 0) {
            int x = queue.peek(); queue.poll();
            list.add(x);
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                dis[y] = dis[x] + 1;
                if (-- deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        if (list.size() != n) {
            System.out.println("Poor Xed");
        } else {
            int ans = 0;
            for(int i = 1; i <= n; i ++) {
                ans += dis[i];
            }
            System.out.println(ans);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1;i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(y, x, 1);
            deg[x] ++;
        }
        topo();
    }
}
