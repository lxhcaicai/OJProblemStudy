package com.lxhcaicai.algorithm.graphTheory.topo.ac1191;

import java.util.*;

public class Main {

    static final int N = 20000;
    static int[] head = new int[N];
    static int[] nex = new int[N];
    static int[] ver = new int[N];
    static int[] deg = new int[N];
    static int n;
    static int tot = 0;

    static void addedge(int x, int y) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static List<Integer> list = new ArrayList<>();

    static void topo() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i <= n; i ++) {
            if (deg[i] == 0) {
                queue.add(i);
                break;
            }
        }
        while (queue.size() > 0) {
            int x = queue.peek(); queue.poll();
            if (x != 0) {
                list.add(x);
            }
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (-- deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            while (true) {
                int x = scanner.nextInt();
                if (x == 0) {
                    break;
                }
                addedge(i, x);
                deg[x] ++;
            }
        }
        for(int i = 1; i <= n; i ++) {
            addedge(0, i);
            deg[i] ++;
        }
        topo();
        list.forEach(e -> System.out.printf(e + " "));
    }
}
