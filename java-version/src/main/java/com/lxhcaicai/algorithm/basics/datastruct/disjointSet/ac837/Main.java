package com.lxhcaicai.algorithm.basics.datastruct.disjointSet.ac837;


import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static int[] fa = new int[N];
    static int[] size = new int[N];

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static void merge(int a, int b) {
        fa[a] = b;
        size[b] += size[a];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            fa[i] = i;
            size[i] = 1;
        }
        while (m -- > 0) {
            String op = scanner.next();
            if (op.contains("C")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                a = find(a);
                b = find(b);
                if (a != b) {
                    merge(a, b);
                }
            } else if(op.contains("Q1")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                a = find(a);
                b = find(b);
                if (a != b) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            } else {
                int a = scanner.nextInt();
                System.out.println(size[find(a)]);
            }
        }
    }
}
