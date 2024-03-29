package com.lxhcaicai.algorithm.mathematicalKnowledge.approximateNumber.ac198;

import java.util.Scanner;

public class Main {

    static final int primes[] = {2,3,5,7,11,13,17,19,23};

    static int maxd;
    static int number;
    static int n;
    static void dfs(int d,int last, int p, int s) {
        if (s > maxd || s == maxd && p < number) {
            maxd = s;
            number = p;
        }
        if (d == 9) {
            return;
        }
        for(int i = 1; i <= last; i ++) {
            if ((long)p * primes[d] > n) {
                break;
            }
            p *= primes[d];
            dfs(d + 1, i, p, s * (i + 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0, 30, 1, 1);
        System.out.println(number);
    }
}
