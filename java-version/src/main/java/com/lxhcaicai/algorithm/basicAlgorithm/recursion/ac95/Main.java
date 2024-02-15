package com.lxhcaicai.algorithm.basicAlgorithm.recursion.ac95;

import java.util.Scanner;

public class Main {
    static final int N = 10;
    static char[][] g = new char[N][N];
    static char[][] backup = new char[N][N];

    static void memcpy(char a[][], char b[][]) {
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                a[i][j] = b[i][j];
            }
        }
    }

    static int dx[] = {0, 0, 0, 1, -1};
    static int dy[] = {0, 1, -1, 0, 0};

    static boolean isok(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }

    static void turn(int x, int y) {
        for(int i = 0; i < 5; i ++) {
            int nx = x +dx[i];
            int ny = y + dy[i];
            if (!isok(nx, ny)) {
                continue;
            }
            if (g[nx][ny] == '1') {
                g[nx][ny] = '0';
            } else {
                g[nx][ny] = '1';
            }
        }
    }

    static int solve() {
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < (1 << 5); k ++) {
            int cnt = 0;
            memcpy(backup, g);
            for(int i = 0; i < 5; i ++) {
                if((k >> i & 1) == 1) {
                    turn(0, i);
                    cnt ++;
                }
            }

            for(int i = 0; i < 4; i ++) {
                for(int j = 0; j < 5; j ++) {
                    if(g[i][j] == '0') {
                        turn(i + 1, j);
                        cnt ++;
                    }
                }
            }

            boolean ok = true;


            for(int i = 0; i < 5; i ++) {
                if(g[4][i] == '0') {
                    ok = false;
                    break;
                }
            }

            if(ok) ans = Math.min(ans, cnt);

            memcpy(g, backup);
        }
        return ans <= 6 ? ans : -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(; T > 0; T --) {
            for(int i = 0; i < 5; i ++) {
                String ss = scanner.next();
                for(int j = 0; j < 5; j ++) {
                    g[i][j] = ss.charAt(j);
                }
            }
            System.out.println(solve());
        }
    }
}
