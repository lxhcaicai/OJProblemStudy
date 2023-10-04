package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac187;

import java.util.Scanner;
// AcWing 187. 导弹防御系统
public class Main {

    static final int N = 65;
    static int a[] = new int[N];
    static int ans = 0;
    static int n = 0;
    static int[] up = new int[N];
    static int[] down = new int[N];

    static void dfs(int u, int su, int sd) {
        if (su + sd >= ans) {
            return;
        }
        if (u > n) {
            ans = su + sd;
            return;
        }

        int k = 1;
        while(k <= su && up[k] >= a[u]) {
            k ++;
        }
        int t = up[k];
        up[k] = a[u];
        if (k <= su) {
            dfs(u + 1, su, sd);
        } else {
            dfs(u + 1, su + 1, sd);
        }
        up[k] = t;


        k = 1;
        while(k <= sd && down[k] <= a[u]) {
            k ++;
        }
        t = down[k];
        down[k] = a[u];
        if (k <= sd) {
            dfs(u + 1, su, sd);
        } else {
            dfs(u + 1, su , sd + 1);
        }
        down[k] = t;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 1; i <= n; i ++) {
                a[i] = scanner.nextInt();
            }
            ans = n;
            dfs(1, 0, 0);
            System.out.println(ans);
        }
    }
}
