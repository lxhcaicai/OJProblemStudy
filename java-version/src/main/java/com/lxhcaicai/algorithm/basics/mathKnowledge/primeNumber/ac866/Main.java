package com.lxhcaicai.algorithm.basics.mathKnowledge.primeNumber.ac866;

import java.util.Scanner;

public class Main {

    static boolean check(int x) {
        if (x < 2) {
            return false;
        }
        for(int i = 2; (long)i * i <= x; i ++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int x = scanner.nextInt();
            if (check(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
