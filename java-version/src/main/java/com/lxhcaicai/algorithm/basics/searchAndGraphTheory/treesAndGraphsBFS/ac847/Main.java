package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.treesAndGraphsBFS.ac847;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[N];
    static int[] nex = new int[N];
    static int tot = 0;

    static void addedge(int x, int y) {
        ver[++tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
    }

    static int[] dis = new int[N];

    static int bfs(int st, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        Arrays.fill(dis, -1);
        dis[st] = 0;
        while (queue.size() > 0) {

            int x = queue.peek();
            queue.poll();
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                if (dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.add(y);
                }
            }
        }
        return dis[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addedge(x,y);
        }
        System.out.println(bfs(1,n));
    }
}
