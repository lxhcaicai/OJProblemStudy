package com.lxhcaicai.algorithm.basics.mathKnowledge.gametheory.ac891;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            ans ^= x;
        }
        if (ans != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
