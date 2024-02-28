package com.lxhcaicai.algorithm.basics.mathKnowledge.inclusionExclusionPrinciple.ac890;

import java.util.Scanner;

public class Main {

    static final int N = 20;

    static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 0; i < m; i ++) {
            p[i] = scanner.nextInt();
        }

        int res = 0;
        for(int i = 1; i < (1 << m); i ++) {
            int t = 1, s= 0;
            for(int j = 0; j < m; j ++) {
                if ((i >> j & 1) ==1) {
                    if ((long) t * p[j] > n) {
                        t = -1;
                        break;
                    }
                    t *= p[j];
                    s++;
                }
            }
            if (t !=-1) {
                if (s % 2 == 1) {
                    res += n / t;
                } else {
                    res -= n / t;
                }
            }
        }
        System.out.println(res);
    }
}
