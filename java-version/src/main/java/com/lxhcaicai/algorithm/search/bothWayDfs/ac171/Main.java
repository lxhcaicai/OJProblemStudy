package com.lxhcaicai.algorithm.search.bothWayDfs.ac171;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 50;
    static int cnt = 0;
    static int K = 0, n = 0;
    static int weight;
    static Integer[] sum = new Integer[1 << 25];
    static Integer[] g = new Integer[N];

    static void dfs1(int d, int s) {
        if (d == K) {
            sum[++cnt] = s;
            return;
        }
        if ((long) s + g[d] <= weight) {
            dfs1(d + 1, s + g[d]);
        }
        dfs1(d + 1, s);
    }

    static long ans = 0;

    static void dfs2(int d,long s) {
        if (d > n) {
            int l = 0, r = cnt;
            int p = 0;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (sum[mid] + s <= weight) {
                    l = mid + 1;
                    p = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (sum[p] + s <= weight) {
                ans = Math.max(ans, sum[p] + s);
            }
            return;
        }
        if (s + g[d] <= weight) {
            dfs2(d + 1, s + g[d]);
        }
        dfs2(d + 1, s);
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        weight = scanner.nextInt();
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            g[i] = scanner.nextInt();
        }
        Arrays.sort(g, 1, n + 1, (a,b)->(b-a));

        K = n/2 + 2;
        dfs1(1, 0);

        int tot = cnt;
        Arrays.sort(sum, 1, 1 + cnt);
        cnt = 1;
        for(int i = 2; i <= tot; i ++) {
            if (sum[i] == sum[cnt]) {
                continue;
            }
            sum[++cnt] = sum[i];
        }
        dfs2(K, 0);
        System.out.println(ans);
    }
}
