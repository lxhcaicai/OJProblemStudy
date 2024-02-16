package com.lxhcaicai.algorithm.mathematicalKnowledge.primeSieve.ac1292;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e6 + 100);

    static boolean[] vis = new boolean[N];
    static int cnt = 0;
    static int[] prime = new int[N];

    static void init(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                prime[++cnt] = i;
            }
            for(int j = 1; j <= cnt && i * prime[j] <= n; j ++) {
                vis[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init((int) (1e6));
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            boolean flag = false;
            for(int j = 1; j <= cnt && prime[j] <= n; j ++) {
                int x = n - prime[j];
                if (!vis[x]) {
                    System.out.println(n+" = "+prime[j]+" + "+x);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
