package com.lxhcaicai.algorithm.mathematicalKnowledge.probability.ac218;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int N = 14;
    static double INF = 1E20;

    static int A, B, C, D;
    static double[][][][][][] f = new double[N][N][N][N][5][5];

    static double dp(int a, int b, int c, int d, int x, int y) {
        if(f[a][b][c][d][x][y] >= 0) {
            return f[a][b][c][d][x][y];
        }

        int as = a, bs = b, cs = c, ds = d;

        if(x == 0) as ++;
        if(x == 1) bs ++;
        if(x == 2) cs ++;
        if(x == 3) ds ++;

        if(y == 0) as ++;
        if(y == 1) bs ++;
        if(y == 2) cs ++;
        if(y == 3) ds ++;

        if (as >= A && bs >= B && cs >=C && ds >= D) {
            return f[a][b][c][d][x][y] = 0;
        }

        int sum = a + b + c + d;
        if (x != 4) {
            sum ++;
        }
        if (y != 4) {
            sum ++;
        }
        sum = 54 - sum;

        if (sum <= 0) {
            return f[a][b][c][d][x][y] = INF;
        }

        f[a][b][c][d][x][y] = 1;
        if (a < 13) f[a][b][c][d][x][y] += (13.0 - a) / sum * dp(a + 1, b, c, d, x, y);
        if(b < 13)  f[a][b][c][d][x][y] += (13.0 - b) / sum * dp(a, b + 1, c, d, x, y);
        if(c < 13)  f[a][b][c][d][x][y] += (13.0 - c) / sum * dp(a, b, c + 1, d, x, y);
        if(d < 13)  f[a][b][c][d][x][y] += (13.0 - d) / sum * dp(a, b, c, d + 1, x, y);

        if (x == 4) {
            double t = INF;
            for(int i = 0; i < 4; i ++) {
                t = Math.min(t, 1.0/ sum * dp(a,b,c,d,i,y));
            }
            f[a][b][c][d][x][y] += t;
        }

        if (y == 4) {
            double t = INF;
            for(int i = 0; i < 4; i ++) {
                t = Math.min(t, 1.0/ sum * dp(a,b,c,d,x,i));
            }
            f[a][b][c][d][x][y] += t;
        }

        return f[a][b][c][d][x][y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        D = scanner.nextInt();
        for(int a = 0; a < N; a ++) {
            for(int b = 0; b < N; b ++) {
                for(int c = 0; c < N; c ++) {
                    for(int d = 0; d < N; d ++) {
                        for(int e = 0; e < 5; e ++) {
                            Arrays.fill(f[a][b][c][d][e], - 1);
                        }
                    }
                }
            }
        }

        double t = dp(0, 0, 0, 0, 4, 4);
        if (t > INF/2) {
            t = -1;
        }
        System.out.printf("%.3f", t);
    }
}
