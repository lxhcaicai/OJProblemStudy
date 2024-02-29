package com.lxhcaicai.algorithm.basics.dynamicPlanning.ac4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1010;
    static int[] f= new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int s = scanner.nextInt();
            for(int k = 1; k <= s; k ++) {
                for(int j = m; j >=v; j --) {
                    f[j] = Math.max(f[j], f[j - v] + w);
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
