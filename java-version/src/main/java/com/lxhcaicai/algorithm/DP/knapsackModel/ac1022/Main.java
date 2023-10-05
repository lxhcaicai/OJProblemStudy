package com.lxhcaicai.algorithm.DP.knapsackModel.ac1022;



import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static final int M = 505;
    static final int f[][] = new int[N][M];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 1; i <= k ; i ++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for (int j = n; j >= a; j --) {
                for (int g = m; g >= b; g -- ) {
                    f[j][g] = Math.max(f[j][g], f[j - a][g - b] + 1);
                }
            }
        }
        int ans = 0, res = 0;
        for(int i = 1; i <= n; i ++){
            for(int j = 0; j < m; j++) {
                if(f[i][j] > ans || (ans == f[i][j]&&res>j)){
                    ans = f[i][j];
                    res = j;
                }
            }
        }

        System.out.println(ans + " " + (m - res));
    }
}
