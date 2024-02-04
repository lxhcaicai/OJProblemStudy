package com.lxhcaicai.algorithm.graphTheory.differenceConstraint.ac1170;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int N = (int) (3E4 + 100);
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


    static int[] dis = new int[N];
    static boolean[] in = new boolean[N];
    static int[] cnt = new int[N];
    static int n, m;

    static boolean spfa(int size) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(in, false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 1; i <= size; i ++) {
            queue.add(i);
            in[i] = true;
            dis[i] = 0;
        }
        Arrays.fill(cnt, 0);
        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            in[x] = false;

            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];

                if(dis[y] > dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    cnt[y] = cnt[x] + 1;
                    if(cnt[y] > n) {
                        return true;
                    }
                    if (!in[y]) {
                        queue.add(y);
                        in[y] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            addedge(i + 1, i, 0);
        }
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        for(; m1 > 0; m1 --) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            addedge(x, y, z);
        }

        for(; m2 > 0; m2 --) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            addedge(y, x, -z);
        }

        if (spfa(n)) {
            System.out.println(-1);
        } else {
            spfa(1);
            if(dis[n] == Integer.MAX_VALUE) {
                System.out.println("-2");
            } else {
                System.out.println(dis[n]);
            }
        }
    }
}
