package com.lxhcaicai.algorithm.basics.basicAlgorithm.binarySearch.ac790;

import java.util.Scanner;

public class Main {

    static final double eps = 1e-8;

    static double n;

    static boolean check(double x) {
        return x *x *x >= n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextDouble();
        double l=-10000,r=10000;
        while (Math.abs(r - l ) > eps) {
            double mid = (l +r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f\n",r);
    }
}
