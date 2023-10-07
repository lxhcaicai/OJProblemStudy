package com.lxhcaicai.algorithm.DP.knapsackModel.ac1023;

import java.util.Scanner;
// AcWing 1023. 买书
public class Main {
    static final int N = 1010;
    static int[] f= new int[N];
    static final int a[] = new int[]{10,20,50,100};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        f[0] = 1;
        for (int i = 0; i < 4; i ++) {
            for(int j = a[i]; j <= n; j ++) {
                f[j] += f[j - a[i]];
            }
        }
        System.out.println(f[n]);
    }
}
