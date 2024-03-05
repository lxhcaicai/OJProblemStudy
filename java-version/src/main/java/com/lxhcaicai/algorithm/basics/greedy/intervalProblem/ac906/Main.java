package com.lxhcaicai.algorithm.basics.greedy.intervalProblem.ac906;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] a = new int[N *2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tot = 0;
        for(int i = 1; i <= n; i ++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            a[++tot] = l * 2;
            a[++tot] = r * 2 + 1;

        }
        Arrays.sort(a, 1,2 * n + 1);
        int res = 0;
        int ans = 0;
        for(int i = 1; i <= tot; i ++) {
            if (a[i] % 2 == 0) {
                res ++;
            } else {
                res --;
            }
            ans = Math.max(res, ans);
        }
        System.out.println(ans);
    }
}
