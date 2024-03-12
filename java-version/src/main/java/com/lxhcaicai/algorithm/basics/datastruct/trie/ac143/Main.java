package com.lxhcaicai.algorithm.basics.datastruct.trie.ac143;

import java.util.Scanner;

public class Main {

    static final int N = (int) (5E6 + 100);
    static int[][] trie = new int[N][2];

    static int tot = 0;
    static void insert(int x) {
        int p = 0;
        for(int i = 31; i >= 0; i --) {
            int j = x >> i & 1;
            if (trie[p][j] == 0) {
                trie[p][j] = ++ tot;
            }
            p = trie[p][j];
        }
    }

    static long query(int x) {
        long res = 0;
        int p = 0;
        for(int i = 31; i >= 0; i --) {
            int j = x >> i & 1;
            if (trie[p][j ^ 1] != 0) {
                res |= 1L << i;
                p = trie[p][j ^ 1];
            } else {
                p = trie[p][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            insert(x);
            ans = Math.max(ans, query(x));
        }
        System.out.println(ans);
    }
}
