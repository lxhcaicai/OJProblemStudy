package com.lxhcaicai.algorithm.graphTheory.differenceConstraint.ac362;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int N = (int) (5e4 + 10);
    static final int M = 3 * N;
    static int[] head = new int[N];
    static int[] ver = new int[M];
    static int[] edge = new int[M];
    static int[] nex = new int[M];
    static int tot = 0;

    static void addedge(int x, int y, int z) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static boolean[] in = new boolean[N];
    static int[] dis = new int[N];
    static void spfa(int st) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(dis, -Integer.MIN_VALUE);
        Arrays.fill(in, false);
        queue.add(st);
        dis[st] = 0;
        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            in[x] = false;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (dis[y] < dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    if (!in[y]) {
                        in[y] = true;
                        queue.add(y);
                    }
                }
            }
        }
    }

    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));

    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = read();
        for(int i = 1; i < N; i ++) {
            addedge(i - 1, i, 0);
            addedge(i, i -1, -1);
        }
        for(int i = 1; i <= n; i ++) {
            int a = read(); a ++;
            int b = read(); b ++;
            int c = read();
            addedge(a - 1, b , c);
        }
        spfa(0);
        System.out.println(dis[N - 1]);
    }
}
