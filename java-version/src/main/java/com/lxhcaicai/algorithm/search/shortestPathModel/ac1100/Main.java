package com.lxhcaicai.algorithm.search.shortestPathModel.ac1100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);
    static int[] dis = new int[N];

    static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        Arrays.fill(dis, -1);
        dis[x] = 0;
        while (queue.size() > 0) {
            x = queue.peek(); queue.poll();
            if (x == y) {
                return dis[y];
            }
            if (x +1 <N && dis[x +1] == -1) {
                dis[x+1] = dis[x] + 1;
                queue.add(x + 1);
            }
            if(x - 1 >= 0 && dis[x - 1] == -1) {
                dis[x - 1] = dis[x] + 1;
                queue.add(x - 1);
            }
            if (x * 2 < N && dis[x * 2] == -1) {
                dis[x *2] = dis[x] + 1;
                queue.add(x * 2);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(bfs(x, y));
    }
}
