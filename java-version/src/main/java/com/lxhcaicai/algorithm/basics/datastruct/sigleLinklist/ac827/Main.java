package com.lxhcaicai.algorithm.basics.datastruct.sigleLinklist.ac827;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int m;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx;

    static void insert(int a, int x) {
        e[idx] = x;
        l[idx] = a;
        r[idx] = r[a];
        l[r[a]] = idx;
        r[a] = idx ++;
    }

    static void remove(int a) {
        l[r[a]] = l[a];
        r[l[a]] = r[a];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        r[0] = 1;
        l[1] = 0;
        idx = 2;
        while (m -- > 0) {
            String op= scanner.next();
            int k, x;
            if (op.equals("L")) {
                x = scanner.nextInt();
                insert(0, x);
            } else if (op.equals("R")) {
                x = scanner.nextInt();
                insert(l[1], x);
            } else if (op.equals("D")) {
                k = scanner.nextInt();
                remove(k + 1);
            } else if (op.equals("IL")) {
                k = scanner.nextInt();
                x = scanner.nextInt();
                insert(l[k + 1], x);
            } else {
                k = scanner.nextInt();
                x = scanner.nextInt();
                insert(k + 1, x);
            }
        }

        for(int i = r[0]; i != 1; i = r[i]) {
            System.out.printf(e[i] + " ");
        }
    }
}
