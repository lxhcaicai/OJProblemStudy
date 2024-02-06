package com.lxhcaicai.algorithm.graphTheory.eulerianPath.ac1124;

import java.util.*;

public class Main {
    static final int N = 510;
    static int[][] g = new int[N][N];
    static int[] d = new int[N];

    static List<Integer> ans = new ArrayList<>();
    static void dfs(int x) {
        for(int i = 1; i < N; i ++) {
            if (g[x][i] > 0) {
                g[x][i] --;
                g[i][x] --;
                dfs(i);
            }
        }
        ans.add(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m -- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x][y] ++;
            g[y][x] ++;
            d[x] ++;
            d[y] ++;
        }

        int start = 1;
        while (d[start] == 0) {
             ++ start;
        }
        for(int i = 1; i < N; i ++) {
            if (d[i] % 2 != 0) {
                start = i;
                break;
            }
        }
        dfs(start);
        Collections.reverse(ans);
        ans.forEach(System.out::println);
    }

}
