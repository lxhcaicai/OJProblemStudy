package com.lxhcaicai.algorithm.basics.dynamicPlanning.countDp.ac900;

import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int[] f = new int[N];
    static final int MOD = (int) (1E9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        f[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = i; j <= n; j ++) {
                f[j] += f[j - i];
                f[j] %= MOD;
            }
        }
        System.out.println(f[n]);
    }
}
