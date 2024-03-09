package com.lxhcaicai.algorithm.basics.greedy.formula.ac125;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static class Node {
        int w, s;

        public Node(int w, int s) {
            this.w = w;
            this.s = s;
        }
    }

    static final Node[] nodes = new Node[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int w = scanner.nextInt();
            int s = scanner.nextInt();
            nodes[i] = new Node(w,s);
        }
        Arrays.sort(nodes,1, n + 1, (a,b)->((a.w + a.s) - (b.w + b.s)));

        long ans = Integer.MIN_VALUE;
        long res = 0;
        for(int i = 1; i <= n;  i ++) {
            ans = Math.max(ans, res - nodes[i].s);
            res += nodes[i].w;
        }
        System.out.println(ans);
    }
}
