package com.lxhcaicai.algorithm.DP.knapsackModel.ac1021;

import java.util.Scanner;
// AcWing 1021. 货币系统
public class Main {
    static final int M = 3010;
    static final int N = 20;
    static int a[] = new int[N];
    static int f[] = new int[M];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        f[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for (int j = a[i]; j <= m; j ++) {
                f[j] += f[j - a[i]];
            }
        }
        System.out.println(f[m]);
    }
}
