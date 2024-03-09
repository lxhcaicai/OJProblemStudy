package com.lxhcaicai.algorithm.basics.greedy.intervalProblem.ac907;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 10);

    static class Node {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static Node[] nodes = new Node[N];

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        int st = scanner.nextInt();
        int ed = scanner.nextInt();
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            nodes[i] = new Node(l, r);
        }

        Arrays.sort(nodes,1,n + 1,(a,b)->(a.l-b.l));

        int res = 0;
        boolean flag = false;
        for(int i = 1; i <= n; i ++) {
            int j = i, r = Integer.MIN_VALUE;
            while (j <= n && nodes[j].l <= st) {
                r = Math.max(r, nodes[j].r);
                j ++;
            }

            if (r < st) {
                res = -1;
                break;
            }

            res ++;
            if (r >= ed) {
                flag = true;
                break;
            }
            st = r;
            i = j - 1;
        }
        if (!flag) {
            res = -1;
        }
        System.out.println(res);
    }
}
