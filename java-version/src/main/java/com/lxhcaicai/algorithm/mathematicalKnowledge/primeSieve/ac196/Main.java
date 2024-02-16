package com.lxhcaicai.algorithm.mathematicalKnowledge.primeSieve.ac196;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> primes = new ArrayList<>();
    static final int N = (int) (1E6 + 100);
    static int[] vis = new int[N];
    static int[] npr = new int[N];
    static int tot = 0;

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (vis[i] == 0) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && (long) i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = 1;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static void solve(int l, int r) {
        Arrays.fill(vis, 0);
        for(long p: primes) {
            for(long j = Math.max((l + p - 1)/p * p, (long) 2 * p); j <= r; j += p) {
                vis[(int) (j - l)] = 1;
            }
        }
        int tot = 0;
        for(int i = 0; i <= r - l; i ++) {
            if (vis[i] == 0 && i + l != 1) {
                npr[tot++] = i + l;
            }
        }
        if (tot < 2) {
            System.out.println( "There are no adjacent primes.");
        } else {
            int maxid = 0, minid = 0;
            for(int i = 0; i < tot - 1; i ++) {
                int d = npr[i + 1] - npr[i];
                if(d > npr[maxid + 1] - npr[maxid]) maxid = i;
                if(d < npr[minid + 1] - npr[minid]) minid = i;
            }
            System.out.printf("%d,%d are closest, %d,%d are most distant.\n",npr[minid], npr[minid+1], npr[maxid], npr[maxid+1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getPrime(N - 1);
        while (scanner.hasNext()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            solve(l, r);
        }
    }
}
