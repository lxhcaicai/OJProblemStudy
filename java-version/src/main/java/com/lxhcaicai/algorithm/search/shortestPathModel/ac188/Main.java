package com.lxhcaicai.algorithm.search.shortestPathModel.ac188;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 300;
    static char[][] ss = new char[N][N];
    static boolean[][] vis = new boolean[N][N];
    static final int dx[]= {1,1,-1,-1,2,2,-2,-2};
    static final int dy[]={2,-2,2,-2,1,-1,1,-1};

    static int n;
    static int m;
    static class Node {
        int x, y, dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isOk(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m && ss[x][y] != '*';
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        while (queue.size() > 0) {
            Node no =queue.peek();
            queue.poll();
            x = no.x;
            y = no.y;
            int dis = no.dis;
            if(vis[x][y]) {
                continue;
            }
            vis[x][y] = true;
            if(ss[x][y] == 'H') {
                return dis;
            }
            for(int i = 0; i < 8; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isOk(nx, ny)) {
                    continue;
                }
                queue.add(new Node(nx, ny, dis + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int x =0, y = 0;
        for(int i = 1; i <= n; i ++) {
            String str = scanner.next();
            for(int j = 0; j < str.length(); j ++) {
                if(str.charAt(j) == 'K') {
                    x = i; y = j + 1;
                }
                ss[i][j + 1] = str.charAt(j);
            }
        }
        System.out.println(bfs(x,y));
    }
}
