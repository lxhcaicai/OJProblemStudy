package com.lxhcaicai.algorithm.basics.datastruct.heap.ac838;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static int n, m;
    static int[] h = new int[N];
    static int cnt;

    static void down(int u) {
        int t = u;
        if (u * 2 <= cnt && h[u * 2] < h[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= cnt && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        if (u != t) {
            int tmp = h[u];
            h[u] = h[t];
            h[t] = tmp;
            down(t);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            h[i] = scanner.nextInt();
        }
        cnt = n;
        for(int i = n /2; i != 0; i --) {
            down(i);
        }
        while (m -- > 0) {
            System.out.printf(h[1] + " ");
            h[1] = h[cnt --];
            down(1);
        }

    }
}
