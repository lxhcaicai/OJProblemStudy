package com.lxhcaicai.algorithm.dataStruct.disjointSet.ac238;

import java.util.Scanner;

public class Main {

    static final int N = (int) (3e4 + 100);

    static int[] dis = new int[N];
    static int[] siz = new int[N];
    static int[] fa = new int[N];
    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            int root = find(fa[x]);
            dis[x] += dis[fa[x]];
            fa[x] = root;
            return fa[x];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < N; i ++) {
            fa[i] = i;
            siz[i] = 1;
        }
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            String op = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int xx = find(x);
            int yy = find(y);

            if (op.contains("M")) {
                if (xx != yy) {
                    fa[xx] = yy;
                    dis[xx] = siz[yy];
                    siz[yy] += siz[xx];
                }
            } else {
                if (xx != yy) {
                    System.out.println(-1);
                } else {
                    System.out.println(Math.max(0, Math.abs(dis[x] - dis[y]) - 1));
                }
            }
        }
    }
}
