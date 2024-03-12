package com.lxhcaicai.algorithm.basics.datastruct.queue.ac829;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] que = new int[N];
    static int lt = 0;
    static int rt = 0;

    static boolean isEmpty() {
        return lt == rt;
    }

    static void push(int x) {
        que[++rt] = x;
    }

    static void pop() {
        ++ lt;
    }

    static int query() {
        return que[lt + 1];
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
