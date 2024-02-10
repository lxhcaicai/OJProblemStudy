package com.lxhcaicai.algorithm.dataStruct.disjointSet.ac1250;

import java.util.Scanner;

public class Main {

    static final int N = (int) (4e4 + 100);
    static int n, m;
    static int cal(int x, int y) {
        return (x - 1) * n + y;
    }

    static int[] fa = new int[N];
    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n * n; i ++) {
            fa[i] = i;
        }
        for(int cnt = 1; cnt <= m; cnt ++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            String ch = scanner.next();
            int x = cal(i, j);
            int y;
            if (ch.charAt(0) == 'D') {
                y =cal(i + 1, j);
            } else {
                y = cal(i, j +1);
            }
            x = find(x);
            y = find(y);
            if (x != y) {
                fa[x] = y;
            } else {
                System.out.println(cnt);
                return;
            }
        }
        System.out.printf("draw");
    }
}
