package com.lxhcaicai.algorithm.basics.datastruct.hashTable.ac840;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (2E5 + 3);
    static final int INF = 0x3f3f3f3f;

    static int[] a = new int[N];

    static int find(int x) {
        int t = (x % N + N) % N;
        while (a[t] != INF && a[t] != x) {
            t ++;
            if (t == N) {
                t = 0;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Arrays.fill(a, INF);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n -- > 0) {
            String op = scanner.next();
            int x = scanner.nextInt();
            if (op.charAt(0) == 'I') {
                a[find(x)] = x;
            } else {
                if (a[find(x)] == INF) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
        }
    }
}
