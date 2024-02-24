package com.lxhcaicai.algorithm.basics.searchAndGraphTheory.bfs.ac845;

import java.util.*;

public class Main {

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};

    static boolean isOk(int x, int y) {
        return 0 <= x && x < 3 && 0 <= y && y < 3;
    }

    static char[][] g = new char[4][4];

    static void turn(int x1, int y1, int x2, int y2) {
        char tmp = g[x2][y2];
        g[x2][y2] = g[x1][y1];
        g[x1][y1] = tmp;
    }

    static void  turnToG(String state) {
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++) {
                g[i][j] = state.charAt(i * 3 + j);
            }
        }
    }

    static String getState() {
        String ss = "";
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++) {
                ss += g[i][j];
            }
        }
        return ss;
    }

    static Long getHash(String state) {
        Long res = 0L;
        for(int i = 0; i < state.length(); i ++) {
            res = res * 17 + state.charAt(i);
        }
        return res;
    }

    static int bfs(String state) {

        String end = "12345678x";
        Queue<String> queue = new LinkedList<>();
        Map<Long, Integer> map = new HashMap<>();
        map.put(getHash(state), 0);
        queue.add(state);
        while (queue.size() > 0) {
            String ss = queue.peek();
            queue.poll();
            int dis = map.get(getHash(ss));
            if (ss.equals(end)) {
                return dis;
            }
            int a = ss.indexOf("x");
            int x = a /3;
            int y = a % 3;
            turnToG(ss);
            for(int i = 0;  i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isOk(nx, ny)) {
                    continue;
                }
                turn(x, y, nx, ny);
                String next = getState();
                Long hash = getHash(next);
                if (!map.containsKey(hash)) {
                    map.put(hash,dis + 1);
                    queue.add(next);
                }
                turn(x, y, nx, ny);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state = "";
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++) {
                String ss = scanner.next();
                g[i][j] = ss.charAt(0);
                state += ss;
            }
        }
        System.out.println(bfs(state));
    }
}
