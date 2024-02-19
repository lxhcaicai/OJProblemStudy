package com.lxhcaicai.algorithm.mathematicalKnowledge.inclusionExclusionPrinciple.ac215;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = 50010;

    static boolean[] vis = new boolean[N];
    static List<Integer> primes = new ArrayList<>();
    static int[] mobius = new int[N];
    static int[] sum = new int[N];

    static void init(int n) {
        mobius[1] = 1;
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
                mobius[i] = -1;
            }
            for(int j = 0; j < primes.size() && (long)i * primes.get(j) <= n ; j ++) {
                int t = i * primes.get(j);
                vis[t] = true;
                if (i % primes.get(j) == 0) {
                    mobius[t] = 0;
                    break;
                }
                mobius[t] = mobius[i] * -1;
            }
        }

        for(int i = 1; i <= n; i ++) {
            sum[i] = sum[i - 1] + mobius[i];
        }
    }

    public static void main(String[] args) {
        init( N - 1);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int d = scanner.nextInt();
            a /= d;
            b /= d;
            int n = Math.min(a, b);
            long res = 0;
            for(int l = 1, r; l <= n; l = r + 1) {
                r = Math.min(n, Math.min(a/(a/l), b/(b/l)));
                res += (sum[r] - sum[l - 1]) * (long)(a/l) * (b/l);
            }
            System.out.println(res);
        }
    }
}
