package com.lxhcaicai.algorithm.graphTheory.flody.ac345;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final int N = 110;
    static final int INF = 0x3f3f3f3f;

    static int[][] g = new int[N][N];
    static Scanner scanner = new Scanner(System.in);
    static int read() {
        return scanner.nextInt();
    }
    static int n;

    static void Mul(int c[][], int a[][], int b[][]) {
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i ++) {
            Arrays.fill(temp[i], INF);
        }
        for(int k = 1; k <= n; k ++) {
            for(int i = 1; i <= n; i ++) {
                for(int j = 1; j <= n; j ++) {
                    temp[i][j] = Math.min(temp[i][j], a[i][k] + b[k][j]);
                }
            }
        }
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                c[i][j] = temp[i][j];
            }
        }
    }

    static int[][] res = new int[N][N];
    static int quick(int b, int s, int e) {
        for(int i = 0; i < N; i ++) {
            Arrays.fill(res[i],INF);
        }
        for(int i = 0; i <= n; i ++) {
            res[i][i] = 0;
        }
        for(; b != 0; b >>= 1) {
            if ((b & 1) == 1) {
                Mul(res, res, g);
            }
            Mul(g, g, g);
        }
        return res[s][e];
    }

    static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int tot = 0;
        int k = read(), t = read(), s = read(), e = read();
        if (!map.containsKey(s)) {
            map.put(s, ++ tot);
        }
        if (!map.containsKey(e)) {
            map.put(e, ++ tot);
        }
        for(int i = 0; i < N; i ++) {
            Arrays.fill(g[i],INF);
        }
        for(int i = 1; i <= t; i ++) {
            int z = read();
            int x = read();
            int y = read();
            if(!map.containsKey(x)) {
                map.put(x, ++ tot);
            }
            if(!map.containsKey(y)) {
                map.put(y, ++ tot);
            }
            int a = map.get(x);
            int b = map.get(y);
            g[a][b] = g[b][a] = Math.min(g[a][b],z);
        }
        n = tot;
        System.out.println(quick(k, map.get(s), map.get(e)));
    }
}
