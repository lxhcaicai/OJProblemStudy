package com.lxhcaicai.algorithm.DP.longestAscendingSubsequenceModel.ac1012;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// AcWing 1012. 友好城市
public class Main {
    static class Node {
        private int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static int N = 5010;
    static Node[] nodes = new Node[N];
    static int f[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            nodes[i] = new Node(x,y);
        }
        Arrays.sort(nodes, 1, n + 1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getX() - o2.getX();
            }
        });
        Arrays.fill(f, 1);
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j < i; j ++) {
                if (nodes[i].getY() > nodes[j].getY()) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(f).max().getAsInt());
    }
}
