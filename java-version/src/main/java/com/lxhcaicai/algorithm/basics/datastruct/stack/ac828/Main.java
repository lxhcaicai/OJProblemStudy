package com.lxhcaicai.algorithm.basics.datastruct.stack.ac828;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] stack = new int[N];
    static int tot = 0;

    static boolean isEmpty() {
        return tot == 0;
    }

    static void push(int x) {
        stack[++tot] = x;
    }

    static void pop() {
        tot --;
    }

    static int query() {
        return stack[tot];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            String op = scanner.next();
            if (op.equals("push")) {
                int x = scanner.nextInt();
                push(x);
            } else if(op.equals("empty")) {
                System.out.println(isEmpty()?"YES":"NO");
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("query")) {
                System.out.println(query());
            }
        }
    }
}
