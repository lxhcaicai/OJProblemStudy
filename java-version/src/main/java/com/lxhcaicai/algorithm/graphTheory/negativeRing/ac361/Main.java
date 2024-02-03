package com.lxhcaicai.algorithm.graphTheory.negativeRing.ac361;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 6000;

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[ ++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static int n;
    static double[] dis = new double[N];
    static int[] cnt = new int[N];
    static int[] f = new int[N];
    static boolean[] in = new boolean[N];

    static boolean check(double mid) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(dis, 0);
        Arrays.fill(cnt, 0);
        for(int i = 1; i <= n; i ++) {
            in[i] = true;
            queue.add(i);
        }
        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            in[x] = false;
            for(int i = head[x]; i !=0 ;i = nex[i]) {
                int y = ver[i];
                double w = edge[i] * mid - f[x];
                if (dis[y] > dis[x] + w) {
                    dis[y] = dis[x] + w;
                    cnt[y] = cnt[x] + 1;
                    if (cnt[y] > n) {
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
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            f[i] = scanner.nextInt();
        }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
        }
        double l = 0, r = 1000;
        final  double eps = 1e-4;
        while(Math.abs(l - r) > eps) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.printf("%.2f", l);
    }
}
