package com.lxhcaicai.algorithm.basics.dynamicPlanning.sectionDp.ac282;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 310;
    static int[][] f=  new int[N][N];
    static int n;

    static int[] sum=  new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            sum[i] = scanner.nextInt();
            sum[i] += sum[i-1];
        }

        for(int i = 1; i <= n; i ++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
            f[i][i] = 0;
        }

        for(int len = 1; len <= n; len ++) {
            for(int i = 1; i + len - 1<= n; i ++) {
                int j = i + len - 1;
                for(int k = i; k < j; k ++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + sum[j] - sum[i-1]);
                }
            }
        }

        System.out.println(f[1][n]);
    }
}
