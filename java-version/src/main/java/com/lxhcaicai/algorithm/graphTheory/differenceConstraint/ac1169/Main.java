package com.lxhcaicai.algorithm.graphTheory.differenceConstraint.ac1169;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static final int N = (int) (3E5 + 100);
    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int[] edge = new int[N];

    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }


    static int[] dis = new int[N];
    static boolean[] in = new boolean[N];
    static int[] cnt = new int[N];
    static int n, m;

    static boolean spfa(int st) {

        Stack<Integer> stack = new Stack<>();
        Arrays.fill(dis,Integer.MIN_VALUE);
        Arrays.fill(in, false);
        dis[st] = 0;
        stack.add(st);
        in[st] = true;
        while(stack.size() > 0) {
            int x = stack.peek();
            stack.pop();
            in[x] = false;
            for(int i = head[x]; i != 0; i =nex[i]) {
                int y = ver[i];
                if (dis[y] < dis[x] + edge[i]) {
                    dis[y] = dis[x] + edge[i];
                    cnt[y] = cnt[x] + 1;
                    if (cnt[y] > n) {
                        return true;
                    }
                    if (!in[y]) {
                        stack.add(y);
                        in[y]=true;
                    }
                }
            }
        }
        return false;
    }

    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));
    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();
        for(int i = 1; i <= m; i ++) {
            int x = read();
            int a = read();
            int b = read();
            if (x == 1) {
                addedge(a, b, 0);
                addedge(b, a, 0);
            } else if (x == 2) {
                addedge(a, b, 1);
            } else if (x == 3) {
                addedge(b, a, 0);
            } else if (x == 4) {
                addedge(b, a, 1);
            } else if (x == 5) {
                addedge(a, b, 0);
            }
        }
        for(int i = 1; i <= n; i ++) {
            addedge(0, i, 1);
        }
        if (spfa(0)) {
            System.out.println(-1);
            return;
        }
        long ans = 0;
        for(int i = 0; i <= n; i ++) {
            ans += dis[i];
        }
        System.out.println(ans);
    }
}
