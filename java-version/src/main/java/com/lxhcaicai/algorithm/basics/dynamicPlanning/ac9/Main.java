package com.lxhcaicai.algorithm.basics.dynamicPlanning.ac9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N =110;
    static int[] f = new int[N];
    static int[][] v = new int[N][N];
    static int[][] w = new int[N][N];
    static int[] c = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i <= n; i ++) {
            c[i] = scanner.nextInt();
            for(int j = 1; j <= c[i]; j ++) {
                v[i][j] = scanner.nextInt();
                w[i][j] = scanner.nextInt();
            }
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >=0; j --) {
                for(int k = 1; k <= c[i]; k ++) {
                    if (j >= v[i][k]) {
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
