package com.lxhcaicai.algorithm.DP.knapsackModel.ac278;

import java.util.Scanner;
// AcWing 278. 数字组合
public class Main {
    static final int N = 110;
    static final int M = 10010;
    static final int a[] = new int[N];
    static final int f[] = new int[M];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1;  i<= n; i ++) {
            a[i] = scanner.nextInt();
        }
        f[0] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int j = m; j >= a[i]; j --) {
                f[j] += f[j - a[i]];
            }
        }
        System.out.println(f[m]);
    }
}
