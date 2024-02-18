package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1308;

import java.util.Scanner;

public class Main {

    static final int N = 150;
    static int ksm(int a, int b, int p) {
        int res = 1;
        for(; b!=0; b >>= 1) {
            if((b & 1) == 1) {
                res = (int) ((long)res * a % p);
            }
            a = (int) ((long)a * a % p);
        }
        return res;
    }
    static int[][][] f = new int[1000][100][N];

    static void add(int[] c, int[] a, int[] b) {
        for(int i = 0, t = 0; i < N; i ++) {
            t += a[i] + b[i];
            c[i] = t % 10;
            t /= 10;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int n = ksm(x % 1000, x, 1000);

        //求组合数C(n-1,k-1)
        //递推式C(i,j) = C(i-1,j-1) + C(i-1,j)
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= i && j < k; j ++) {
                if (j == 0) {
                    f[i][j][0] = 1;
                } else {
                    add(f[i][j], f[i-1][j], f[i-1][j-1]);
                }
            }
        }

        int it = N - 1;
        while (f[n-1][k-1][it] == 0) {
            it --;
        }
        for(int i = it; i >= 0; i --) {
            System.out.printf("%d", f[n-1][k-1][i]);
        }
    }
}
