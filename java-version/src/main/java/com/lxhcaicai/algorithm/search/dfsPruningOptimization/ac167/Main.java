package com.lxhcaicai.algorithm.search.dfsPruningOptimization.ac167;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 110;
    static Integer[] a = new Integer[N];

    static int n, len, cnt;
    static int[] vis = new int[N];

    static boolean dfs(int d, int now, int last) {
        if (d > cnt) {
            return true;
        }
        if (now == len) {
            return dfs(d + 1, 0, 1);
        }
        int fail = 0;
        for(int i = last; i <= n; i ++) {
            if (vis[i] == 0 && now + a[i] <= len && fail != a[i]) {
                vis[i] = 1;
                if (dfs(d, now + a[i], i + 1)) {
                    return true;
                }
                vis[i] = 0;
                fail = a[i];
                if (now == 0 || now + a[i] == len) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            int mx = 0, sum = 0;
            for(int i = 1; i <= n; i ++) {
                a[i] = scanner.nextInt();
                mx = Math.max(mx, a[i]);
                sum += a[i];
            }
            Arrays.sort(a, 1, 1 + n, (a, b)->(b-a));

            for(len = mx; len <= sum; len ++) {
                if (sum % len != 0) {
                    continue;
                }
                cnt = sum / len;
                Arrays.fill(vis, 0);
                if (dfs(1, 0, 1)) {
                    System.out.println(len);
                    break;
                }
            }
        }
    }
}
