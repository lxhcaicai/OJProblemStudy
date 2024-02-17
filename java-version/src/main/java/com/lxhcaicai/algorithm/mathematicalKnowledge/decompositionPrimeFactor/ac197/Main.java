package com.lxhcaicai.algorithm.mathematicalKnowledge.decompositionPrimeFactor.ac197;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e6 + 100);

    static List<Integer> primes = new ArrayList<>();
    static boolean[] vis = new boolean[N];

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static int get(int n, int s) {
        int ans = 0;
        while (n!=0) {
            ans += n/s;
            n /=s;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrime(n);
        for(int x: primes) {
            System.out.println(x + " " + get(n, x));
        }
    }
}
