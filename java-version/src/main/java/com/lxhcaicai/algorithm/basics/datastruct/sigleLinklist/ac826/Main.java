package com.lxhcaicai.algorithm.basics.datastruct.sigleLinklist.ac826;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int head;
    static int[] edge = new int[N];
    static int[] nex = new int[N];
    static int tot = -1;
    static void init() {
        head = -1;
        tot = 0;
    }

    static void addToHead(int x) {
        edge[tot] = x;
        nex[tot] = head;
        head = tot++;
    }

    static void add(int k, int x) {
        edge[tot] = x;
        nex[tot] = nex[k];
        nex[k] = tot++;
    }

    static void remove(int k) {
        nex[k] = nex[nex[k]];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        init();;
        while (n -- > 0) {
            int k;
            int x;
            String op = scanner.next();
            if (op.charAt(0) == 'H') {
                x = scanner.nextInt();
                addToHead(x);
            } else if (op.charAt(0) == 'D') {
                k = scanner.nextInt();
                if (k == 0) {
                    head = nex[head];
                } else {
                    remove(k - 1);
                }
            } else {
                k = scanner.nextInt();
                x = scanner.nextInt();
                add(k - 1, x);
            }
        }
        for(int i = head; i != -1; i = nex[i]) {
            System.out.printf(edge[i]+" ");
        }
    }
}
