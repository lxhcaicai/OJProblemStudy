package com.lxhcaicai.algorithm.graphTheory.flody.ac1125;

import java.util.Scanner;

public class Main {

    static final int N = 155;
    static final double INF = 1E20;

    static int n;
    static class  Pair {
        double x,y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static Pair[] p = new Pair[N];

    static double[][] d = new double[N][N];
    static double[] maxd = new double[N];

    static double getDist(Pair a, Pair b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy *dy);
    }

    static void flody() {
        for(int k = 0; k < n; k ++) {
            for (int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            p[i] = new Pair(x, y);
        }

        for(int i = 0; i < n; i ++) {
            char[] ch = scanner.next().toCharArray();
            for(int j = 0; j < n; j ++) {
                if (i != j) {
                    if(ch[j] == '1') {
                        d[i][j] = getDist(p[i],p[j]);
                    } else {
                        d[i][j] =INF;
                    }
                }
            }
        }

        flody();
        double res1 = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(d[i][j] < INF / 2) {
                    maxd[i] = Math.max(maxd[i],d[i][j]);
                }
            }
            res1 = Math.max(res1, maxd[i]);
        }

        double res2 = INF;
        for(int i = 0; i < n; i ++) {
            for(int j = 0 ; j < n; j ++) {
                if(d[i][j] > INF /2) {
                    res2 = Math.min(res2, maxd[i] + maxd[j] + getDist(p[i], p[j]));
                }
            }
        }

        System.out.printf("%.6f", Math.max(res1, res2));
    }
}
