package com.lxhcaicai.algorithm.search.ida.ac181;

import java.util.Scanner;

/*
      0     1
      2     3
4  5  6  7  8  9  10
      11    12
13 14 15 16 17 18 19
      20    21
      22    23
*/
public class Main {

    static final int[][] turn = {
            {0, 2, 6, 11, 15, 20, 22},
            {1, 3, 8, 12, 17, 21, 23},
            {10, 9, 8, 7, 6, 5, 4},
            {19, 18, 17, 16, 15, 14, 13},
            {23, 21, 17, 12, 8, 3, 1},
            {22, 20, 15, 11, 6, 2, 0},
            {13, 14, 15, 16, 17, 18, 19},
            {4, 5, 6, 7, 8, 9, 10}
    };

    static int[] opposite = {5, 4, 7, 6, 1, 0, 3, 2};
    static int[] center = {6, 7, 8, 11, 12, 15, 16, 17};

    static int[] a = new int[25];
    static int[] path = new int[20];
    static int[] sum = new int[4];

    static int f() {
        for(int i = 0; i < 4; i ++) {
            sum[i] = 0;
        }
        for(int i = 0; i < 8; i ++) {
            sum[a[center[i]]] ++;
        }
        int s = 0;
        for(int i =1;i <= 3; i ++) {
            s = Math.max(s, sum[i]);
        }
        return 8 - s;
    }

    static boolean check() {
        for(int i = 0 ; i < 8; i ++) {
            if(a[center[i]] != a[center[0]]) {
                return false;
            }
        }
        return true;
    }

    static void doturn(int x) {
        int t = a[turn[x][0]];
        for(int i = 0; i < 6; i ++) {
            a[turn[x][i]] = a[turn[x][i + 1]];
        }
        a[turn[x][6]] = t;
    }

    static boolean dfs(int d, int maxdep, int last) {
        if (f() + d > maxdep) {
            return false;
        }
        if (check()) {
            return true;
        }
        for(int i = 0; i < 8; i ++) {
            if (last == opposite[i]) {
                continue;
            }
            doturn(i);
            path[d] = i;
            if (dfs(d + 1, maxdep, i)) {
                return true;
            }
            doturn(opposite[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            a[0] = scanner.nextInt();
            if (a[0] == 0) {
                break;
            }
            for(int i = 1; i < 24; i ++) {
                a[i] = scanner.nextInt();
            }
            for(int dep = 0; ; dep ++) {
                if (dfs(0, dep, -1)) {
                    if (dep == 0) {
                        System.out.println("No moves needed");
                    } else {
                        for(int i = 0; i < dep; i ++) {
                            System.out.printf("%c", path[i] + 'A');
                        }
                        System.out.println();
                    }
                    System.out.println(a[6]);
                    break;
                }
            }
        }
    }
}
