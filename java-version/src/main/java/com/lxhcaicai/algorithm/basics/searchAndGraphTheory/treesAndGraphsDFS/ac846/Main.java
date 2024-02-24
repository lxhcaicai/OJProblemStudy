package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.treesAndGraphsDFS.ac846;

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

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int dfs(int x,int fa) {
        int size = 0, sum = 0;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (y == fa) {
                continue;
            }
            int s = dfs(y, x);
            size = Math.max(size, s);
            sum += s;
        }
        size = Math.max(size, n - sum - 1);
        ans = Math.min(ans, size);

        return sum + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n - 1; i ++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x, y);
            addedge(y,x);
        }
        dfs(1, 0);

        System.out.println(ans);
    }
}
