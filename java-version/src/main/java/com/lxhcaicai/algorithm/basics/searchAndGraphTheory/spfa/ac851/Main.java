package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.spfa.ac851;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
    static boolean[] in = new boolean[N];

    static String spfa(int st, int ed) {
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[st] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            in[x] = false;
            for(int i = head[x]; i !=0 ; i = nex[i]) {
                int y = ver[i];
                if (dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    if (!in[y]) {
                        in[y] = true;
                        queue.add(y);
                    }
                }
            }
        }
        if (dis[ed] == Integer.MAX_VALUE) {
            return "impossible";
        }
        return String.valueOf(dis[ed]);
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

        System.out.println(spfa(1, n));
    }
}
