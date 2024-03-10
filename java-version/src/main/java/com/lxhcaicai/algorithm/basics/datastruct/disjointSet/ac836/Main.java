package com.lxhcaicai.algorithm.basics.datastruct.disjointSet.ac836;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static int[] fa = new int[N];

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
        }
        while (m -- > 0) {
            String op = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            a = find(a);
            b = find(b);
            if (op.charAt(0) == 'M') {
                if (a != b) {
                    fa[a] = b;
                }
            } else {
                if (a != b) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
        }
    }
}
