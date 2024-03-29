package com.lxhcaicai.algorithm.search.iterativeDeeping.ac170;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 500;

    static int[] vis = new int[N];
    static int n;
    static int[] a = new int[N];

    static boolean dfs(int d, int dep) {
        if (a[d-1] == n) {
            return true;
        }
        if (d > dep) {
            return false;
        }
        for(int i = d - 1; i >= 1; i --) {
            for(int j = i; j >= 1; j --) {
                int t = a[i] + a[j];
                if (vis[t] == 1 | t <= a[d - 1] || t > n) {
                    continue;
                }
                vis[t] = 1;
                a[d] = t;
                if (dfs(d + 1, dep)) {
                    return true;
                }
                vis[t] = 0;
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
            for(int dep = 1; ; dep ++) {
                a[1] = 1;
                Arrays.fill(vis, 0);
                if (dfs(2, dep)) {
                    for(int i = 1;  i <= dep; i ++) {
                        System.out.printf("%d ", a[i]);
                    }
                    System.out.println();
                    break;
                }
            }
        }
    }
}
