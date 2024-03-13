package com.lxhcaicai.algorithm.basics.datastruct.queue.ac154;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1E6 + 100);

    static int[] q = new int[N];
    static int[] a = new int[N];
    static int l = 0, r = 0;
    
    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();
        for(int i = 1; i <= n; i ++) {
            a[i] = read();
        }
        l = 0;
        r=  0;
        for(int i = 1; i <= n; i ++) {
            while (l <= r && i - q[l] >= k) {
                l ++;
            }
            while (l <= r && a[q[r]] >= a[i]) {
                r --;
            }
            q[++r] = i;
            if (i >= k) {
                out.printf(a[q[l]] + " ");
            }
        }
        out.println();

        l = 0;
        r=  0;
        for(int i = 1; i <= n; i ++) {
            while (l <= r && i - q[l] >= k) {
                l ++;
            }
            while (l <= r && a[q[r]] <= a[i]) {
                r --;
            }
            q[++r] = i;
            if (i >= k) {
                out.printf(a[q[l]] + " ");
            }
        }
        out.flush();
    }
}
