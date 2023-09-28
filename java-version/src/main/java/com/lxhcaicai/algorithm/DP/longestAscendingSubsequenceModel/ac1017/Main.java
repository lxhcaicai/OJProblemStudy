package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac1017;

import java.util.Arrays;
import java.util.Scanner;
// AcWing 1017. 怪盗基德的滑翔翼
public class Main {
    static final int N = 110;
    static int h[] = new int[N];
    static int f[] = new int[N];
    static int g[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(;t > 0; t--) {
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i ++) {
                h[i] = scanner.nextInt();
            }
            Arrays.fill(f, 1);
            Arrays.fill(g,1);
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j < i; j ++) {
                    if (h[j] > h[i]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
            }
            g[n] = 1;
            for (int i = n; i >= 1; i --) {
                for (int j = n; j > i; j --) {
                    if (h[j] > h[i]) {
                        g[i] = Math.max(g[i], g[j] + 1);
                    }
                }
            }
            System.out.println(Math.max(Arrays.stream(f).max().getAsInt(), Arrays.stream(g).max().getAsInt()));;
        }
    }
}
