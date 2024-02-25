package com.lxhcaicai.algorithm.basics.mathKnowledge.primeNumber.ac867;

import java.util.Scanner;

public class Main {

    static void solve(int x) {
        for(int i = 2; (long)i * i <= x; i ++) {
            int cnt = 0;
            if (x % i == 0) {
                while (x % i == 0) {
                    cnt ++;
                    x /= i;
                }
                System.out.println(i + " " + cnt);
            }
        }
        if (x > 1) {
            System.out.println(x + " " + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int x = scanner.nextInt();
            solve(x);
            System.out.println();
        }
    }
}
