package com.lxhcaicai.algorithm.DP.knapsackModel.ac1024;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 20010;
    static int f[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            for (int j = V; j >= v; j --) {
                f[j] = Math.max(f[j], f[j - v] + v);
            }
        }

        System.out.println(V - Arrays.stream(f).max().getAsInt());
    }
}
