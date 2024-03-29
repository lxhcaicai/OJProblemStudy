package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1310;

import java.util.Scanner;

public class Main {

    static int gcd(int x, int y) {
        if(y == 0) return x;
        else {
            return gcd(y, x % y);
        }
    }

    static long C(int n) {
        return (long) n * (n - 1) * (n - 2) / 6;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        n ++;
        m ++;
        long res = C(n *m) - n * C(m) -m *C(n);
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                res -= 2 * (n - i) * (m - j) * (gcd(i, j) - 1);
            }
        }
        System.out.println(res);
    }
}
