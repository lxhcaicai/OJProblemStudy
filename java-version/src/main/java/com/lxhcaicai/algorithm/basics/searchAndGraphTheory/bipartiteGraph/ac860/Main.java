package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.bipartiteGraph.ac860;

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

    static int[] color = new int[N];

    static boolean dfs(int x, int c) {
        color[x] = c;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (color[y] == 0) {
                if (!dfs(y, 3 - c)) {
                    return false;
                }
            } else if (color[y] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x, y);
            addedge(y, x);
        }

        boolean flag = true;
        for(int i = 1;  i<= n; i ++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
