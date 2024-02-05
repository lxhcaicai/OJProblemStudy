package com.lxhcaicai.algorithm.graphTheory.doubleConnect.ac1183;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 30010;
    static int[] head = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;
    static int[] ver = new int[N];
    static void addedge(int x, int y) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }
    static int ans = 0;

    static int[] dfn = new int[N];
    static int[] low = new int[N];
    static int[] cut = new int[N];
    static int num = 0;
    static int root = 0;

    static void tarjan(int x) {
        low[x] = dfn[x] = ++ num;
        int flag = 0;

        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (dfn[y] == 0) {
                tarjan(y);
                low[x] = Math.min(low[x], low[y]);
                if (low[y] >= dfn[x]) {
                    flag ++;
                }
            } else {
                low[x] = Math.min(low[x], dfn[y]);
            }
        }
        if (root != x) {
            flag ++;
        }
        ans = Math.max(ans, flag);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            Arrays.fill(head, 0);
            Arrays.fill(dfn, 0);
            tot = 0;
            for(int i = 1; i <= m; i ++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                addedge(x, y);
                addedge(y, x);
            }
            ans = 0;
            int cnt = 0;
            for(int i = 0; i < n; i ++) {
                if (dfn[i] == 0) {
                    cnt ++;
                    root = i;
                    tarjan(root);
                }
            }

            System.out.println(ans + cnt - 1);
        }
    }
}
