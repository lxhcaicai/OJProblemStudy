package com.lxhcaicai.algorithm.search.dfsSearchOrder.ac1118;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static final int N = 20;

    static List<Integer>[] lists = new List[N];

    static int ans = 0;

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static boolean check(List<Integer> list, int x) {
        for(int y : list) {
            if (gcd(x,y) != 1) {
                return false;
            }
        }
        return true;
    }

    static int[] a = new int[N];

    static void dfs(int d, int len) {
        if (len >= ans) {
            return;
        }
        if (d > n) {
            ans = Math.min(ans, len);
            return;
        }
        for(int i = 1; i <= len; i ++) {
            if (check(lists[i], a[d])) {
                lists[i].add(a[d]);
                dfs(d +1, len);
                lists[i].remove(lists[i].size() - 1);
            }
        }
        lists[len + 1].add(a[d]);
        dfs(d +1, len + 1);
        lists[len + 1].remove(lists[len + 1].size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for(int i = 1; i <= n + 1; i ++) {
            lists[i] = new LinkedList<>();
        }
        ans = n;
        dfs(1,1);
        System.out.println(ans);
    }
}
