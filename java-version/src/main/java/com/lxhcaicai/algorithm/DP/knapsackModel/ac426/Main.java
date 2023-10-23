package com.lxhcaicai.algorithm.DP.knapsackModel.ac426;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 30010;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            for (int j = m; j >= v; j --) {
                f[j] = Math.max(f[j], f[j -v] + v * p);
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
