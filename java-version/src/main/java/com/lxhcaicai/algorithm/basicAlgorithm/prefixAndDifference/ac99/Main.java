package com.lxhcaicai.algorithm.basicAlgorithm.prefixAndDifference.ac99;

import java.util.Scanner;

public class Main {

    static final int N = 5010;
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        m = Math.min(m, 5001); // 边长大于 5001，就是对整个图求和

        int r = m, c= m;
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            x ++;
            y ++;
            f[x][y] += z;
        }
        for(int i = 1; i <= 5001; i ++) {
            for(int j = 1; j <= 5001; j ++) {
                f[i][j] += f[i-1][j] + f[i][j-1] - f[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i = m; i <= 5001; i ++) {
            for (int j = m; j <= 5001; j++) {
                ans= Math.max(ans, f[i][j] - f[i-m][j] - f[i][j-m] + f[i-m][j-m]);
            }
        }
        System.out.println(ans);
    }
}
