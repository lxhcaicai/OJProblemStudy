package com.lxhcaicai.algorithm.graphTheory.stronglyConnected.ac1174;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static final int N = (int) (1E5 + 100);
    static int[] head = new int[N];
    static int[] ver = new int[N << 1];
    static int[] nex = new int[N << 1];
    static int tot = 0;

    static void addedge(int x, int y) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] dfn = new int[N];
    static int[] low = new int[N];
    static int[] col = new int[N];
    static boolean[] ins = new boolean[N];
    static int[] nums = new int[N];

    static int cnt = 0;
    static int num = 0;
    static Stack<Integer> stack = new Stack<>();

    static void tarjan(int x) {
        dfn[x] = low[x] = ++ num;
        stack.push(x);
        ins[x] = true;
        for(int i = head[x]; i != 0; i = nex[i]) {
            int y = ver[i];
            if (dfn[y] == 0) {
                tarjan(y);
                low[x] = Math.min(low[x],low[y]);
            } else if (ins[y]) {
                low[x] = Math.min(low[x], dfn[y]);
            }
        }
        if (dfn[x] == low[x]) {
            cnt ++;
            int y;
            do {
                y = stack.peek();
                stack.pop();
                col[y] = cnt;
                nums[cnt] ++;
            }while (x!=y);
        }
    }

    static int[] deg = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x, y);
        }

        for(int i = 1; i <= n; i ++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }

        for(int x = 1; x <= n; x ++) {
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (col[x] != col[y]) {
                    deg[col[x]] ++;
                }
            }
        }

        int sum = 0;
        int flag = 0;
        for(int i = 1; i <= cnt; i ++) {
            if (deg[i] == 0) {
                sum += nums[i];
                flag ++;
                if (flag > 1 ) {
                    sum = 0;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
