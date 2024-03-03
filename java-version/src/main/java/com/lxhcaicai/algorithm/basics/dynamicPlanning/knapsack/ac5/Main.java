package com.lxhcaicai.algorithm.basics.dynamicPlanning.knapsack.ac5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = (int) (1e5 + 100);
    static int[] f = new int[N];
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int tot = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            for(int j = 1; j <= c; j *= 2) {
                c -= j;
                v[++ tot] = a * j;
                w[tot] = b * j;
            }
            if (c > 0) {
                v[++ tot] = a * c;
                w[tot] = b * c;
            }
        }
        for(int i = 1; i <= tot; i ++) {
            for(int j = m; j >=v[i]; j --) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
