package com.lxhcaicai.algorithm.basics.dynamicPlanning.linearDp.ac899;

import java.util.Scanner;

public class Main {

    static int N = 1010;
    static int[][] f=  new int[N][N];

    static String[] aStr = new String[N];
    static String[] bStr = new String[N];

    static int check(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        for(int i = 1; i <= n; i ++) {
            f[i][0] = i;
        }
        for(int i = 1; i <= m; i ++) {
            f[0][i] = i;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] = Math.min(f[i][j-1], f[i-1][j]) + 1;
                if (a.charAt(i) == b.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            aStr[i] = scanner.next();
            aStr[i] = ' ' + aStr[i];
        }
        for(int i = 1; i <= m; i ++) {
            bStr[i] = scanner.next();
            bStr[i] = ' ' + bStr[i];
            int limit = scanner.nextInt();
            int res = 0;
            for(int j = 1; j <= n; j ++) {
                if (check(aStr[j], bStr[i]) <= limit) {
                    res ++;
                }
            }
            System.out.println(res);
        }
    }
}
