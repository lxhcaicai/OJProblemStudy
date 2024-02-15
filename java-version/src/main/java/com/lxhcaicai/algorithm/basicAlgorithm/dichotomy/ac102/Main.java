package com.lxhcaicai.algorithm.basicAlgorithm.dichotomy.ac102;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);
    static final double eps = 1e-8;
    static double[] sum = new double[N];
    static int[] a = new int[N];
    static int n, m;

    static boolean check(double avg) {
        for(int i = 1; i <= n; i ++) {
            sum[i] = sum[i-1] + (a[i] - avg);
        }
        double mins = 0;
        for(int i = m; i <= n; i ++) {
            mins = Math.min(mins, sum[i - m]);
            if (sum[i] >= mins) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }

        double l = 0, r = 2000;
        while (Math.abs(r - l) > eps) {
            double mid = (r + l) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.printf("%d", (int)(r * 1000));
    }
}
