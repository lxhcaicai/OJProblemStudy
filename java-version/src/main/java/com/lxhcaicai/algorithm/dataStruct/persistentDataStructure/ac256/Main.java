package com.lxhcaicai.algorithm.dataStruct.persistentDataStructure.ac256;

import java.util.Scanner;

public class Main {

    static final int N = (int) (4e5 + 100);
    static final int M = 25 * N;
    static int[][] trie = new int[M][2];
    static int tot = 0;
    static int[] maxId = new int[M];
    static int[] s = new int[N];
    static int[] root = new int[M];

    static void insert(int i, int k, int p, int q){
        if(k<0){
            maxId[q]=i;
            return;
        }
        int v=s[i]>>k&1;
        if(p != 0) trie[q][v^1]=trie[p][v^1];
        trie[q][v]=++tot;
        insert(i,k-1,trie[p][v],trie[q][v]);
        maxId[q]=Math.max(maxId[trie[q][0]],maxId[trie[q][1]]);
    }


    static int query(int rt, int C, int L) {
        int p = rt;
        for(int i = 23; i >= 0; i--) {
            int v = C >> i & 1;
            if (maxId[trie[p][v ^ 1]] >= L) {
                p = trie[p][v ^ 1];
            } else {
                p = trie[p][v];
            }
        }
        return C ^ s[maxId[p]];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        maxId[0] = -1;
        root[0] = ++tot;
        insert(0, 23, 0, root[0]);
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            s[i] = s[i -1] ^ x;
            root[i] = ++ tot;
            insert(i, 23, root[i-1], root[i]);
        }

        for(int i = 1; i <= m; i ++) {
            String op = scanner.next();
            if (op.charAt(0) == 'A') {
                int x = scanner.nextInt();
                root[++n] = ++ tot;
                s[n] = s[n - 1] ^x;
                insert(n, 23, root[n-1], root[n]);
            } else {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int x = scanner.nextInt();
                System.out.println(query(root[r-1],x^s[n],l-1));
            }
        }
    }
}
