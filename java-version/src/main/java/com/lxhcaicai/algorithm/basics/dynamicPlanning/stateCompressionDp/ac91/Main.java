package com.lxhcaicai.algorithm.basics.dynamicPlanning.stateCompressionDp.ac91;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 20;

    static int [][]f = new int[1 << N][N];
    static int [][] dis = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                dis[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < (1 << n); i ++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
        }

        f[1][0] = 0;
        for(int i = 1; i < (1 <<n); i ++) {
            for(int j = 0; j < n; j ++) {
                if ((i >> j & 1) == 1) {
                    for(int k = 0; k < n; k ++) {
                        if (((i ^ (1<<j)) >> k & 1) ==1) {
                            f[i][j] = Math.min(f[i][j], f[i ^ (1 << j)][k] + dis[k][j]);
                        }
                    }
                }
            }
        }

        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}
