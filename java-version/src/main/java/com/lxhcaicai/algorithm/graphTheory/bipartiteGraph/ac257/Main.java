package com.lxhcaicai.algorithm.graphTheory.bipartiteGraph.ac257;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (2e5 + 100);
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] edge = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;

    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static int n, m;
    static int[] color = new int[N];
    static boolean dfs(int x, int c, int mid) {
        color[x] = c;
        for(int i = head[x]; i !=0 ; i = nex[i]) {
            int y = ver[i];
            if (edge[i] <= mid) {
                continue;
            }
            if (color[y] != 0) {
                if (color[y] == c) {
                    return false;
                }
            } else if (!dfs(y, c ^ 1, mid)) {
                return false;
            }
        }
        return true;
    }

    static boolean check(int mid) {
        Arrays.fill(color, 0);
        for(int i = 1; i <= n; i ++) {
            if (color[i] == 0) {
                if (!dfs(i, 3, mid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addedge(x, y, z);
            addedge(y, x, z);
        }

        int l = 0, r = (int) 1e9;
        int ans = 0;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
