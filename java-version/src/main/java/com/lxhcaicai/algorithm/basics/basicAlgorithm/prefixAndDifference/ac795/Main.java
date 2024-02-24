package com.lxhcaicai.algorithm.basics.basicAlgorithm.prefixAndDifference.ac795;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] sum = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            sum[i] = scanner.nextInt();
            sum[i] += sum[i - 1];
        }
        while (m -- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(sum[r] - sum[l - 1]);
        }
    }
}
