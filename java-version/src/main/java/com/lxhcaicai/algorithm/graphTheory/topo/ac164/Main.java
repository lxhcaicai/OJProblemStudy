package com.lxhcaicai.algorithm.graphTheory.topo.ac164;

import java.util.*;

public class Main {
    static final int N = (int) (3e4 + 10);

    static int[]head = new int[N];
    static int[]ver = new int[N];
    static int[]nex = new int[N];
    static int tot = 0;
    static void addedge(int x, int y) {
        ver[++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int n;
    static int[] deg = new int[N];

    static Stack<Integer> stack = new Stack<>();

    static void topo() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i ++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int x = queue.peek();
            queue.poll();
            stack.push(x);
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if ( -- deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x, y);
            deg[y] ++;
        }

        topo();

        BitSet[] bitSets = new BitSet[N];
        for(int i = 1; i <= n; i ++) {
            bitSets[i] = new BitSet(n + 1);
            bitSets[i].set(i);
        }
        while (stack.size() > 0) {
            int x = stack.peek();
            stack.pop();
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                bitSets[x].or(bitSets[y]);
            }
        }
        for(int i = 1; i <= n; i ++) {
            System.out.println(bitSets[i].cardinality());
        }
    }
}
