package com.lxhcaicai.algorithm.basics.datastruct.trie.ac835;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static int[][] trie = new int[N][30];
    static int[] cnt = new int[N];
    static int tot = 0;

    static void insert(String str){
        int len = str.length();
        int p = 0;
        for(int k = 0; k < len; k ++) {
            int ch = str.charAt(k) - 'a';
            if (trie[p][ch] == 0) {
                trie[p][ch] = ++tot;
            }
            p = trie[p][ch];
        }
        cnt[p] ++;
    }

    static int query(String str) {
        int len = str.length();
        int p = 0;
        for(int k = 0; k < len; k ++) {
            int ch = str.charAt(k) - 'a';
            p = trie[p][ch];
            if (p == 0) {
                return 0;
            }
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            String op = scanner.next();
            String x = scanner.next();
            if (op.charAt(0) == 'I') {
                insert(x);
            } else {
                System.out.println(query(x));
            }
        }
    }
}
