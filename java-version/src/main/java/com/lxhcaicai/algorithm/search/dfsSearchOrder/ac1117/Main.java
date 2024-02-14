package com.lxhcaicai.algorithm.search.dfsSearchOrder.ac1117;

import java.util.Scanner;

public class Main {

    static final int N = 25;
    static int[] cnt = new int[N];
    static int n;
    static String[] str = new String[N];
    static int ans = 0;

    static void dfs(String ss) {
        int len = ss.length();
        ans = Math.max(ans, len);
        for(int i = 1; i <= n; i ++) {
            for(int j = len - 1, k = 1; j > 0 && k < str[i].length(); j -- , k ++) {
                if (cnt[i] < 2 && ss.substring(j).equals(str[i].substring(0, k))) {
                    String t = ss.substring(0, len - k) + str[i];
                    cnt[i] ++;
                    dfs(t);
                    cnt[i] --;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            str[i] = scanner.next();
        }
        String start = scanner.next();
        start = " " + start;
        dfs(start);
        System.out.println(ans - 1);
    }
}
