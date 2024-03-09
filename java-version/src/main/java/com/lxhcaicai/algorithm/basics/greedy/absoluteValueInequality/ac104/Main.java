package com.lxhcaicai.algorithm.basics.greedy.absoluteValueInequality.ac104;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, 1, n + 1);
        int ans = 0;
        int mid = (1 + n) / 2;
        for(int i = 1; i <= n; i ++) {
            ans += Math.abs(a[mid] - a[i]);
        }
        System.out.println(ans);
    }
}
