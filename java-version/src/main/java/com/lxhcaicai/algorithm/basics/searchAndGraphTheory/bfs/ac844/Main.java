package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.bfs.ac844;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 110;
    static int[][] g = new int[N][N];
    static boolean[][] vis = new boolean[N][N];
    static int n, m;
    static class Node {
        int x, y, dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};

    static boolean isOk(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1, 0));
        while (queue.size()  > 0) {
            Node no = queue.peek();
            queue.poll();
            int x = no.x;
            int y = no.y;
            if (vis[x][y]) {
                continue;
            }
            vis[x][y] = true;
            if (x == n && y == m) {
                return no.dis;
            }
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isOk(nx, ny) && g[x][y] != 1) {
                    queue.add(new Node(nx, ny, no.dis + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                g[i][j] = scanner.nextInt();
            }
        }
        System.out.println(bfs());
    }
}
