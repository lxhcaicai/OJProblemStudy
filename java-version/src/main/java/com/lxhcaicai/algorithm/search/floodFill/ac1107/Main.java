package com.lxhcaicai.algorithm.search.floodFill.ac1107;

import java.util.*;

public class Main {

    static final int N = 10;

    static void tran(int state, int num[][]) {
        for(int i = 1; i <= 4; i ++) {
            num[2][i] = state % 10;
            state /= 10;
        }
        for(int i = 4; i >= 1; i --) {
            num[1][i] = state % 10;
            state /= 10;
        }
    }

    static int State(int num[][]) {
        int res = 0;
        for(int i = 1; i <= 4; i ++) {
            res = res * 10 + num[1][i];
        }
        for(int i = 4; i >= 1; i --) {
            res = res * 10 + num[2][i];
        }
        return res;
    }

    static void A(int num[][]) {
        for(int i = 1; i <= 4;i ++) {
            int tmp = num[1][i];
            num[1][i] = num[2][i];
            num[2][i] = tmp;
        }
    }

    static void B(int num[][]) {
        int x = num[1][4];
        int y = num[2][4];
        for(int i = 4; i >= 2; i --) {
            num[1][i] = num[1][i - 1];
            num[2][i] = num[2][i - 1];
        }
        num[1][1] = x;
        num[2][1] = y;
    }

    static void C(int num[][]) {
        int a = num[1][2];
        int b = num[1][3];
        int c = num[2][3];
        int d = num[2][2];

        num[1][2] = d;
        num[1][3] = a;
        num[2][2] = c;
        num[2][3] = b;

    }

    static class Node {
        String step;
        int dis;
        int state;

        public Node(String step, int dis, int state) {
            this.step = step;
            this.dis = dis;
            this.state = state;
        }
    }

    static Map<Integer,Integer> vis = new HashMap<>();
    static boolean check(int state) {
        return vis.containsKey(state);
    }

    static void bfs(int ed) {
        if (ed == 12345678) {
            System.out.println(0);
            return;
        }
        int [][]a = new int[N][N];

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node("", 0, 12345678));
        while (queue.size() > 0) {
            Node no = queue.peek(); queue.poll();
            int state = no.state;
            String step = no.step;
            int dis = no.dis;

            if (state == ed) {
                System.out.println(dis);
                System.out.println(step);
                return;
            }

            if (check(state)) {
                continue;
            }
            vis.put(state, 1);

            {
                tran(state, a);
                A(a);
                int now = State(a);
                if (check(now) == false) {
                    queue.add(new Node(step + "A", dis + 1, now));
                }
            }
            {
                tran(state, a);
                B(a);
                int now = State(a);
                if (check(now) == false) {
                    queue.add(new Node(step + "B", dis + 1, now));
                }
            }
            {
                tran(state, a);
                C(a);
                int now = State(a);
                if (check(now) == false) {
                    queue.add(new Node(step + "C", dis + 1, now));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        for(int i = 1; i <= 8; i ++) {
            int x = scanner.nextInt();
            res = res * 10 +x;
        }
        bfs(res);
    }
}
