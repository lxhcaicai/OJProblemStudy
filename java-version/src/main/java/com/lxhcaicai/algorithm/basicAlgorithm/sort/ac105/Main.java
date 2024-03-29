package com.lxhcaicai.algorithm.basicAlgorithm.sort.ac105;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = (int) (1e5 + 100);
    static int[] col = new int[N];
    static int[] row = new int[N];
    static int[] c = new int[N];
    static int[] sum = new int[N];

    static long work(int n, int a[]) {
        for(int i = 1; i <= n; i ++) {
            sum[i] = sum[i - 1] + a[i];
        }
        if (sum[n] % n != 0) {
            return -1;
        }
        int avg = sum[n] / n;

        c[1] = 0;
        for (int i = 2; i <= n; i ++) {
            c[i] = sum[i-1] - (i - 1) * avg;
        }
        Arrays.sort(c, 1, n + 1);

        long res = 0;
        for(int i = 1; i <= n; i ++) {
            res += Math.abs(c[i] - c[(n + 1)/2]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int cnt = scanner.nextInt();
        for(int i = 1; i <= cnt; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            row[x] ++;
            col[y] ++;
        }

        long r = work(n, row);
        long c = work(m, col);

        if (r != -1 && c != -1) {
            System.out.println("both " + (r + c));
        } else if(r != -1) {
            System.out.println("row " + r);
        } else if(c != -1) {
            System.out.println("column " + c);
        } else {
            System.out.println("impossible");
        }
    }
}
