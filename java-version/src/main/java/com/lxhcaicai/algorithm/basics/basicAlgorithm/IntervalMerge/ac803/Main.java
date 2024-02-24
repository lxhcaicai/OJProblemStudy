package com.lxhcaicai.algorithm.basics.basicAlgorithm.IntervalMerge.ac803;

import java.util.*;

public class Main {

    static class Node {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n;  i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Node(x,y));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.l == o2.l) {
                    return o1.r - o2.r;
                }
                return o1.l - o2.l;
            }
        });

        int cnt = 0;
        int w = 0;
        for(Node no: list) {
            if (cnt == 0) {
                cnt ++;
                w = no.r;
            } else {
                if (w >= no.l) {
                    w = Math.max(w, no.r);
                } else {
                    cnt ++;
                    w = no.r;
                }
            }
        }

        System.out.println(cnt);
    }
}
