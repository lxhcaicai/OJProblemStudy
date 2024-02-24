package com.lxhcaicai.algorithm.basics.basicAlgorithm.prefixAndDifference.ac796;

import java.util.Scanner;

public class Main {

    static final int N = 1010;

    static int[][] f = new int[N][N];
    static int[][] a = new int[N][N];
    static int query(int x1, int y1, int x2, int y2) {
        return f[x2][y2] - f[x1-1][y2] - f[x2][y1-1] + f[x1-1][y1-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] = scanner.nextInt();
                f[i][j] += f[i - 1][j] + f[i][j - 1] - f[i-1][j-1] ;
            }
        }

        while (q -- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(query(x1,y1, x2, y2));
        }
    }
}
