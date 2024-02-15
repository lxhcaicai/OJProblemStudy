package com.lxhcaicai.algorithm.basicAlgorithm.recursion.ac98;

import java.util.Scanner;

public class Main {
    static class Node {
        long x, y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static Node get(int n, long m) {
        if (m == 0) {
            return new Node(0, 0);
        }
        long len = (long) 1 << (n - 1);
        long block = (long) 1 << (2 * n -2);
        Node no = get(n - 1, m % block);
        long x = no.x;
        long y = no.y;
        long z = m/block;
        if (z == 0) {
            return new Node(y, x);
        } else if (z == 1) {
            return new Node(x, y + len);
        } else if (z == 2) {
            return new Node(x + len, y + len);
        } else {
            return new Node(2 * len - y - 1, len - x - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(; T > 0; T --) {
            int n = scanner.nextInt();
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            Node A = get(n, a-1);
            Node B = get(n, b -1);
            double dx = A.x - B.x;
            double dy = A.y - B.y;
            double dis = Math.sqrt(dx * dx  + dy * dy) * 10;
            System.out.printf("%.0f\n", dis);
        }
    }
}
