package com.lxhcaicai.algorithm.graphTheory.doubleConnect.ac396;

import java.util.*;

public class Main {

    static final int N = 1010;
    static int n, m;
    static int[] head = new int[N];
    static int[] nex = new int[N];
    static int[] ver = new int[N];
    static int tot = 0;
    static void addedge(int x, int y) {
        ver[++ tot] = y;

        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] low = new int[N];
    static List<Integer>[] dcc = new List[N];
    static boolean[] cut = new boolean[N];
    static int root;
    static int[] dfn = new int[N];
    static int num = 0;
    static int dcc_cnt = 0;
    static Stack<Integer> stack = new Stack<>();
    static void tarjan(int x) {
        dfn[x] = low[x] = ++ num;
        stack.push(x);

        if (x == root && head[x] == 0) {
            dcc_cnt ++;
            dcc[dcc_cnt] = new ArrayList<>();
            dcc[dcc_cnt].add(x);
            return;
        }
        int cnt = 0;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (dfn[y] == 0) {
                tarjan(y);
                low[x] = Math.min(low[x], low[y]);
                if (low[y] >= dfn[x]) {
                    cnt ++;
                    if (x != root || cnt > 1) {
                        cut[x] = true;
                    }
                    dcc_cnt ++;
                    dcc[dcc_cnt] = new ArrayList<>();
                    int u;
                    do {
                        u = stack.peek();
                        stack.pop();
                        dcc[dcc_cnt].add(u);
                    }while (u != y);
                    dcc[dcc_cnt].add(x);
                }
            } else {
                low[x] = Math.min(low[x], dfn[y]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 0;
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            if (m == 0) {
                break;
            }
            dcc_cnt = 0;
            tot = 0;
            num = 0;
            n = 0;
            Arrays.fill(head, 0);
            Arrays.fill(dfn, 0);
            Arrays.fill(cut, false);

            while (m -- > 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                n = Math.max(n, a);
                n = Math.max(n, b);
                addedge(a, b);
                addedge(b,a);
            }

            for(root = 1; root <= n; root ++) {
                if (dfn[root] == 0) {
                    tarjan(root);
                }
            }

            int res = 0;
            long num = 1;

            for(int i = 1; i <= dcc_cnt; i ++) {
                int cnt = 0;
                for(int j : dcc[i]) {
                    if (cut[j]) {
                        cnt ++;
                    }
                }

                if (cnt == 0) {
                    if (dcc[i].size() > 1) {
                        res += 2;
                        num *= dcc[i].size() * (dcc[i].size() - 1) /2;
                    } else {
                        res ++;
                    }
                } else if (cnt == 1) {
                    res ++;
                    num *= dcc[i].size() - 1;
                }
            }

            System.out.printf("Case %d: %d %d\n", ++T, res, num);
        }
    }
}
