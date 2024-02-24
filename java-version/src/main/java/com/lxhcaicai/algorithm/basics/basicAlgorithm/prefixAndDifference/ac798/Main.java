package com.lxhcaicai.algorithm.basics.basicAlgorithm.prefixAndDifference.ac798;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

    static final int N = 1010;
    static int[][] f = new int[N][N];
    static int[][] a = new int[N][N];
    static void insert(int x1, int y1, int x2, int y2, int c) {
        f[x1][y1] += c;
        f[x2 + 1][y1] -= c;
        f[x1][y2 + 1] -= c;
        f[x2 + 1][y2 + 1] += c;
    }
    
    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));

    static PrintWriter printWriter = new PrintWriter(System.out);
    
    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = read();
        int m = read();
        int q = read();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                a[i][j] = read();
            }
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                insert(i,j,i,j,a[i][j]);
            }
        }

        while (q -- > 0) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();
            int c = read();
            insert(x1,y1,x2,y2,c);
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] += f[i-1][j] + f[i][j-1] - f[i-1][j-1];
            }
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                printWriter.printf("%d ", f[i][j]);
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
