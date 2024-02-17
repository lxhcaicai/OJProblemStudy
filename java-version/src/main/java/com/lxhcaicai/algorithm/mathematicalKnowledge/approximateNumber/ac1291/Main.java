package com.lxhcaicai.algorithm.mathematicalKnowledge.approximateNumber.ac1291;

import java.util.Scanner;

public class Main {

    static int N = (int) (1e6 + 100);
    static int[] cnt = new int[N];
    static int[] a = new int[N];
    static int[] ans = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
            cnt[a[i]] ++;
        }

        for(int i = 1; i <N; i ++) {
            if (cnt[i] == 0) {
                continue;
            }
            for(int j = i;  j < N; j += i) {
                ans[j] += cnt[i];
            }
        }

        for(int i = 1; i <= n; i ++) {
            System.out.println(ans[a[i]] - 1);
        }
    }
}
