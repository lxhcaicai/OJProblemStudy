package com.lxhcaicai.algorithm.basics.mathKnowledge.extendgcd.ac877;

import java.util.Scanner;

public class Main {

    static int x;
    static int y;

    static int exgcd(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int d = exgcd(b, a %b);
        int z = x;
        x = y;
        y = z - x * (a/b);
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            exgcd(a, b);
            System.out.println(x +" " + y);
        }
    }
}
