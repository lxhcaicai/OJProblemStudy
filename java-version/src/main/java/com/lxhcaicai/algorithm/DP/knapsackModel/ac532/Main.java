package com.lxhcaicai.algorithm.DP.knapsackModel.ac532;

import java.util.Arrays;
import java.util.Scanner;
// AcWing 532. 货币系统
public class Main {

    static final int N = 25010;

    static boolean[] f = new boolean[N];
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t -- > 0) {
            int n = scanner.nextInt();
            Arrays.fill(f, false);
            for (int i = 1;  i<= n; i ++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a, 1, n + 1);
            int m = a[n];
            f[0] = true;
            int ans = 0;
            for(int i = 1; i <= n; i ++) {
                if(!f[a[i]]) {
                    ans ++;
                }
                for(int j = a[i]; j <= m; j ++) {
                    f[j] |= f[j - a[i]];
                }
            }
            System.out.println(ans);
        }
    }
}
