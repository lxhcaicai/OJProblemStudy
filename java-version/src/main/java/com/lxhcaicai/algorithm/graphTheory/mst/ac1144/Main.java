package com.lxhcaicai.algorithm.graphTheory.mst.ac1144;

import java.util.Scanner;

public class Main {
    static final int N = (int) (1E6 + 100);


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

    static int n, m;
    static int cal(int x, int y) {
        return (x - 1) * m + y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n * m ; i ++) {
            fa[i] = i;
        }
        while (scanner.hasNext()) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int x = find(cal(x1, y1));
            int y = find(cal(x2, y2));
            if(x != y) {
                fa[x] = y;
            }
        }
        int ans = 0;
        for(int j = 1;  j <= m; j ++) {
            for(int i = 1; i + 1 <= n; i ++) {
                int x = find(cal(i, j));
                int y = find(cal(i + 1, j));
                if(x != y) {
                    ans ++;
                    fa[x] = y;
                }
            }
        }

        for(int i = 1;  i <= n; i ++) {
            for(int j = 1; j + 1 <= m; j ++) {
                int x = find(cal(i, j));
                int y = find(cal(i, j + 1));
                if(x != y) {
                    ans +=2;
                    fa[x] = y;
                }
            }
        }

        System.out.println(ans);
    }
}
