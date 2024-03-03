package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac895;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
            f[i] = 1;
            for(int j = 1; j < i; j ++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
