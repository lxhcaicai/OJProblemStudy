package com.lxhcaicai.algorithm.search.dfsPruningOptimization.ac165;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 20;

    static int[] car = new int[N];
    static Integer[] a = new Integer[N];

    static int n, w;

    static int ans;

    static void dfs(int d, int now) {
        if (d >= ans) {
            return;
        }
        if (now > n) {
            ans = Math.min(ans, d);
            return;
        }
        for(int i = 1; i <= d; i ++) {
            if (car[i] + a[now] <= w) {
                car[i] += a[now];
                dfs(d, now + 1);
                car[i] -= a[now];
            }
        }
        car[d + 1] += a[now];
        dfs(d + 1, now + 1);
        car[d + 1] -= a[now];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        w = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, 1, n + 1, (a, b) -> (b -a));
        ans = n;
        dfs(1,1);
        System.out.println(ans);
    }
}
