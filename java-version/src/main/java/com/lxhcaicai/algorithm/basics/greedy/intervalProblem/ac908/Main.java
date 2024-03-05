package com.lxhcaicai.algorithm.basics.greedy.intervalProblem.ac908;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static class Node {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static Node[] nodes = new Node[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            nodes[i] = new Node(l, r);
        }
        Arrays.sort(nodes, 1, n + 1,(a,b)->(a.r- b.r));

        int res = 1;
        int maxR = nodes[1].r;
        for(int i = 2; i<=n; i ++) {
            if (maxR < nodes[i].l) {
                res ++;
                maxR = nodes[i].r;
            } else {
                maxR = Math.min(maxR, nodes[i].r);
            }
        }
        System.out.println(res);
    }
}
