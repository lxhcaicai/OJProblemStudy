package com.lxhcaicai.algorithm.search.twoEndQueueWideSearch.ac175;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static final int N = 510;
    static final int dx[] = {-1, -1, 1, 1};
    static final int dy[] = {-1, 1, 1, -1};
    static final int ix[] = {-1, -1, 0, 0};
    static final int iy[] = {-1, 0, 0, -1};

    static final char[] cs = {'\\','/','\\','/'};

    static char[][] ss = new char[N][N];

    static int n, m;
    static boolean isOk(int x, int y) {
        return 0 <= x && x <= n && 0 <= y && y <= m;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dis = new int[N][N];

    static int bfs() {
        Deque<Pair> deque = new LinkedList<>();
        deque.addLast(new Pair(0,0));
        for(int i = 0; i <= n; i ++) {
            Arrays.fill(dis[i], 0x3f3f3f3f);
        }
        dis[0][0] = 0;
        while (deque.size() > 0) {
            Pair no = deque.getFirst();
            deque.pollFirst();
            int x = no.x;
            int y = no.y;
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int a = x + ix[i];
                int b = y + iy[i];

                if (isOk(nx, ny)) {
                    int w = 0;
                    if (ss[a][b] != cs[i]) {
                        w = 1;
                    }
                    if (dis[nx][ny] > dis[x][y] + w) {
                        dis[nx][ny] = dis[x][y] + w;
                        if (w==1) {
                            deque.addLast(new Pair(nx, ny));
                        } else {
                            deque.addFirst(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        if (dis[n][m] == 0x3f3f3f3f) {
            return -1;
        }
        return dis[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(; t > 0; t --) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for(int i = 0; i < n; i ++) {
                String str = scanner.next();
                for(int j = 0; j < m; j ++) {
                    ss[i][j] = str.charAt(j);
                }
            }
            int ans = bfs();
            if(ans == -1) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println(ans);
            }
        }
    }
}
