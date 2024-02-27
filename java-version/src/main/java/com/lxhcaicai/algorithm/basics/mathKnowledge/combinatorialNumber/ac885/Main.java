package com.lxhcaicai.algorithm.basics.mathKnowledge.combinatorialNumber.ac885;

import java.util.Scanner;

public class Main {

    static final  int N =2010;
    static final int MOD = (int) (1E9 + 7);

    static int[][] c = new int[N][N];

    static void init() {
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j <= i; j ++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i-1][j] + c[i-1][j-1]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) {
        init();;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c[a][b]);
        }
    }
}
