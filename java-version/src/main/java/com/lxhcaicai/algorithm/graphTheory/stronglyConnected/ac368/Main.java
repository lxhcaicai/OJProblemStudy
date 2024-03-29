package com.lxhcaicai.algorithm.graphTheory.stronglyConnected.ac368;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Main {

    static final int N = (int) (5E5 + 100);
    static int[] head1 = new int[N];
    static int[] head2 = new int[N];
    static int[] ver = new int[N];
    static int[] edge = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;
    static void addedge(int head[], int x, int y, int z) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }

    static int[] low = new int[N];
    static int[] dfn = new int[N];
    static int num = 0;
    static int scc_cnt = 0;
    static int[] scc_size = new int[N];
    static int[] color = new int[N];
    static boolean[] ins = new boolean[N];
    static Stack<Integer> stack = new Stack<>();

    static void tarjan(int x) {
        dfn[x] = low[x] = ++num;
        stack.push(x);
        ins[x] = true;

        for(int i = head1[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (dfn[y] == 0) {
                tarjan(y);
                low[x] = Math.min(low[x], low[y]);
            } else if (ins[y]) {
                low[x] = Math.min(low[x], dfn[y]);
            }
        }

        if (dfn[x] == low[x]) {
            scc_cnt ++;
            int y;
            do {
                y = stack.peek();
                stack.pop();
                ins[y] = false;
                color[y] = scc_cnt;
                scc_size[scc_cnt] ++;
            } while (x != y);
        }
    }

    static int[] dist = new int[N];
    static StreamTokenizer cin = new StreamTokenizer(new InputStreamReader(System.in));

    static int read() throws IOException {
        cin.nextToken();
        return (int) cin.nval;
    }



    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        for(int i = 1; i <= n; i ++) {
            addedge(head1, 0, i, 1);
        }
        for(int i = 1; i <= m; i ++) {
            int t = read();
            int a = read();
            int b = read();

            if (t == 1) {
                addedge(head1, a, b, 0);
                addedge(head1, b, a, 0);
            }
            if (t == 2) {
                addedge(head1,a, b,1);
            }
            if (t == 3) {
                addedge(head1, b, a, 0);
            }
            if (t == 4) {
                addedge(head1, b, a, 1);
            }
            if (t == 5) {
                addedge(head1, a, b, 0);
            }
        }

        tarjan(0);

        boolean success = true;
        for(int x = 0; x <= n; x ++) {
            for(int i = head1[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                int a = color[x];
                int b = color[y];

                if(a == b) {
                    if (edge[i] > 0) {
                        success = false;
                        break;
                    }
                } else {
                    addedge(head2, a, b, edge[i]);
                }
            }
            if (!success) {
                break;
            }
        }

        if (!success) {
            System.out.println(-1);
        } else {
            for(int x = scc_cnt; x > 0; x --) {
                for(int i = head2[x]; i != 0; i = nex[i]) {
                    int y = ver[i];
                    dist[y] = Math.max(dist[y],dist[x] + edge[i] );
                }
            }

            long ans = 0;
            for(int i = 1; i <= scc_cnt; i ++) {
                ans += (long) dist[i] * scc_size[i];
             }

            System.out.println(ans);
        }
    }
}
