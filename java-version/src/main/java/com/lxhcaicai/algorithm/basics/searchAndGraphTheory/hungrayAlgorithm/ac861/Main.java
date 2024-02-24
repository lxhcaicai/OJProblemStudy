package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.hungrayAlgorithm.ac861;

import java.util.Scanner;

public class Main {

    static final int N = (int) (2e5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;

    static void addedge(int x, int y) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] vis = new int[N];
    static int cnt = 0;
    static int[] match = new int[N];

    static boolean dfs(int x) {
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (vis[y] != cnt ) {
                vis[y] = cnt;
                if (match[y] == 0 || dfs(match[y])) {
                    match[y] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x, y + n1);
            addedge(y + n1, x);
        }
        int ans = 0;
        for(int i = 1; i <= n1; i ++) {
            cnt ++;
            if (dfs(i)) {
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
