package com.lxhcaicai.algorithm.search.ida.ac180;

import java.util.Scanner;

public class Main {

    static final int N = 20;
    static int[][] w = new int[6][N];
    static int[] a = new  int[N];
    static int n;

    static int f() {
        int res = 0;
        for(int i = 1; i + 1 <= n; i  ++) {
            if (a[i + 1] != a[i] + 1) {
                res ++;
            }
        }
        return (res + 2) / 3;
    }

    static boolean check() {
        for(int i = 1; i <= n; i ++) {
            if (a[i] != i) {
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int d, int maxdep) {
        if (f() + d > maxdep) {
            return false;
        }
        if (check()) {
            return true;
        }
        for(int l = 1; l <= n; l ++) {
            for(int r = l; r <= n; r ++) {
                for(int k = r + 1; k <= n; k ++) {
                    int x, y;
                    for(int i = 1; i <= n; i ++) {
                        w[d][i] = a[i];
                    }
                    for(x = r + 1,y = l; x <= k; y ++, x ++) {
                        a[y] = w[d][x];
                    }
                    for(x = l; x <= r; y ++, x ++) {
                        a[y] = w[d][x];
                    }
                    if (dfs(d + 1, maxdep)) {
                        return true;
                    }
                    for(int i = 1; i <= n; i ++) {
                        a[i] = w[d][i];
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(; t > 0; t --) {
            n = scanner.nextInt();
            for(int i = 1; i <= n; i ++) {
                a[i] = scanner.nextInt();
            }
            boolean flag = false;
            for(int d = 0; d <= 4; d ++) {
                if (dfs(0, d)) {
                    flag = true;
                    System.out.println(d);
                    break;
                }
            }
            if (flag == false) {
                System.out.println("5 or more");
            }
        }
    }
}
