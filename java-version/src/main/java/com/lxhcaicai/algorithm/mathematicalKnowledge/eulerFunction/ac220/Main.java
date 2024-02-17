package com.lxhcaicai.algorithm.mathematicalKnowledge.eulerFunction.ac220;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e7 + 100);

    static boolean[] vis = new boolean[N];
    static int[] phi =  new int[N];
    static List<Integer> primes = new ArrayList<>();
    static long[] sum = new long[N];

    static void getPhi(int n) {
        phi[1] = 0;
        for(int i = 2; i <= n; i ++) {
            if(!vis[i]) {
                primes.add(i);
                phi[i] = i - 1;
            }
            for(int j = 0; j < primes.size() && (long) i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    phi[i * primes.get(j)] = phi[i] * primes.get(j);
                    break;
                } else {
                    phi[i * primes.get(j)] = phi[i] * phi[primes.get(j)];
                }
            }
        }
        for(int i = 1; i <= n; i ++) {
            sum[i] = sum[ i - 1] + phi[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPhi(n);
        long ans = 0;
        for(int p: primes) {
            ans += sum[n/p] * 2 + 1;
        }
        System.out.println(ans);
    }
}
