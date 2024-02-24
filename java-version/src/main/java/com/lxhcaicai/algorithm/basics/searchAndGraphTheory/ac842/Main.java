package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.ac842;

import java.util.Scanner;

public class Main {
    static int[] a = new int[10];
    static int n;
    static boolean[] vis = new boolean[10];

    static void dfs(int d) {
        if (d > n) {
            for(int i = 1; i <= n; i ++) {
                System.out.printf(a[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i ++) {
            if (vis[i]) {
                continue;
            }
            a[d] = i;
            vis[i] = true;
            dfs(d + 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        n = scanner.nextInt();
        dfs(1);
    }
}
