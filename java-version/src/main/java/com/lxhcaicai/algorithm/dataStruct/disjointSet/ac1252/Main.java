package com.lxhcaicai.algorithm.dataStruct.disjointSet.ac1252;

import java.util.Scanner;

public class Main {

    static int N = (int) (1E4 + 100);

    static int[] fa = new int[N];
    static int find(int x) {
        if(x == fa[x]) {
            return x;
        }
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static int[] weight = new int[N];
    static int[] val = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int w = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            weight[i] = scanner.nextInt();
            val[i] = scanner.nextInt();
        }

        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            x = find(x);
            y = find(y);
            if (x != y) {
                fa[x] = y;
                weight[y] += weight[x];
                val[y] += val[x];
            }
        }

        for(int i = 1; i <= n; i ++) {
            if (fa[i]==i) {
                for(int j = w; j >= weight[i]; j --) {
                    f[j] = Math.max(f[j], f[j - weight[i]] + val[i]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= w; i ++) {
            ans = Math.max(ans, f[i]);
        }
        System.out.println(ans);
    }
}
