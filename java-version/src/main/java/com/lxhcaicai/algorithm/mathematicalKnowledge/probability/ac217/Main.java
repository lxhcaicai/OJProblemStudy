package com.lxhcaicai.algorithm.mathematicalKnowledge.probability.ac217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = (int) (2E5 + 100);

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

    static int[] dout = new int[N];

    static double[] f = new double[N];

    static double dfs(int x) {
        if (f[x] >= 0) {
            return f[x];
        }
        f[x] = 0;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            f[x] += (edge[i] + dfs(y)) / dout[x];
        }
        return f[x];
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            dout[x] ++;
        }
        Arrays.fill(f, -1);
        System.out.printf("%.2f",dfs(1));
    }
}
