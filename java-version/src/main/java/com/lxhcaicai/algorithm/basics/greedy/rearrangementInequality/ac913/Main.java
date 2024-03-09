package com.lxhcaicai.algorithm.basics.greedy.rearrangementInequality.ac913;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, 1, n + 1);
        long ans = 0;
        for(int i = 1; i <= n - 1; i ++) {
            ans += (n - i) * a[i];
        }
        System.out.println(ans);
    }
}
