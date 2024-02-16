package com.lxhcaicai.algorithm.mathematicalKnowledge.primeSieve.ac1293;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> primes = new ArrayList<>();

    static final int N = (int) (1E5 + 100);

    static int[] vis = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrime(n + 10);
        if (n <= 2) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
        for(int i = 2; i <= n + 1; i ++) {
            if (vis[i] == 0) {
                System.out.printf("1 ");
            } else {
                System.out.printf("2 ");
            }
        }
    }

    private static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (vis[i] == 0) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && i*primes.get(j) <= n; j ++)  {
                vis[i * primes.get(j)] = 1;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }
}
