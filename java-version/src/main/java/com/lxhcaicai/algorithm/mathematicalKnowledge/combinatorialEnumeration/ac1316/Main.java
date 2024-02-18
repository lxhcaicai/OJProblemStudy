package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (2e6 + 100);
    static List<Integer> primes = new ArrayList<>();
    static boolean[] vis = new boolean[N];

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && (long) i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static int get(int n, int p) {
        int res = 0;
        while (n !=0) {
            res += n/p;
            n /=p;
        }
        return res;
    }

    static int MOD;
    static long ksm(long a, int b) {
        long res = 1;
        for(; b != 0; b >>= 1) {
            if((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
        }
        return  res;
    }

    public static void main(String[] args) {
        getPrime(N - 1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MOD = scanner.nextInt();
        long C1 = 1, C2 = 1;

        for(int p: primes) {
            int s = get(2 * n, p) - get(2*n - n, p) - get(n,p);
            C1 = C1 * ksm(p,s) % MOD;
        }

        for(int p: primes) {
            int s = get(2 * n, p) - get(2*n - (n -1), p) - get(n-1,p);
            C2 = C2 * ksm(p,s) % MOD;
        }

        System.out.println(((C1 - C2) % MOD + MOD) % MOD);
    }
}
