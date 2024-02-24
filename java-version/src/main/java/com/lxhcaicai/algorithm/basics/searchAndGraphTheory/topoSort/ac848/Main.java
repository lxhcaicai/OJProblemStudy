package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.topoSort.ac848;

import java.util.*;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;

    static void addedge(int x, int y) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] deg = new int[N];

    static List<Integer> topo(int n) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i ++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }
        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            list.add(x);
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (-- deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x,y);
            deg[y] ++;
        }
        List<Integer> list = topo(n);
        if (list.size() != n) {
            System.out.println("-1");
            return;
        }
        list.forEach(e -> System.out.printf(e + " "));
    }
}
