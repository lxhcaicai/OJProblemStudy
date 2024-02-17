package com.lxhcaicai.algorithm.mathematicalKnowledge.eulerFunction.ac201;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static boolean[] vis = new boolean[N];
    static int[] phi =  new int[N];
    static List<Integer> primes = new ArrayList<>();

    static void getPhi(int n) {
        phi[1] = 1;
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
                phi[i] = i - 1;
            }
            for(int j = 0; j < primes.size() && i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    phi[i * primes.get(j)] = phi[i] * primes.get(j);
                } else {
                    phi[i * primes.get(j)] = phi[i] * phi[primes.get(j)];
                }
            }
        }
    }

    public static void main(String[] args) {
        getPhi(1000);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 1; t <= T; t ++) {
            int n = scanner.nextInt();
            int ans = 0;
            for(int i = 1; i <= n; i ++) {
                ans += phi[i];
            }
            System.out.println(t + " " + n + " " + (ans * 2 + 1));
        }
    }
}
