package com.lxhcaicai.algorithm.basics.mathKnowledge.gametheory.ac892;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            if ((i& 1) ==1) {
                ans ^= x;
            }
        }
        if (ans != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
