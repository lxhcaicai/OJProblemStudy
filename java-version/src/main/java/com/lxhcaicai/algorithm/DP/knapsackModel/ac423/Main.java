package com.lxhcaicai.algorithm.DP.knapsackModel.ac423;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static final int f[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= m; i ++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            for (int j = t; j >= w; j --) {
                f[j] = Math.max(f[j], f[j - w] + v);
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
