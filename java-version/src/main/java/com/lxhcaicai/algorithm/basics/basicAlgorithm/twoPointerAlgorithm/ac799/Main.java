package com.lxhcaicai.algorithm.basics.basicAlgorithm.twoPointerAlgorithm.ac799;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int[] a = new int[N];
    static int[] cnt = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        int ans = 0;
        for(int i = 1, j = 1; i <= n; i ++) {
            cnt[a[i]] ++;
            while (j < i && cnt[a[i]] > 1) {
                cnt[a[j ++]] --;
            }
            ans = Math.max(ans, i - j + 1);
        }
        System.out.println(ans);
    }
}
