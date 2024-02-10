package com.lxhcaicai.algorithm.dataStruct.ac239;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static int N = (int) (1E4  + 100);

    static int[] fa = new int[N];

    static int[] st = new int[N];

    static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            int root = find(fa[x]);
            st[x] ^= st[fa[x]];
            fa[x] = root;

            return fa[x];
        }
    }

    static class Query {
        int l, r;
        int ans;

        public Query(int l, int r, int ans) {
            this.l = l;
            this.r = r;
            this.ans = ans;
        }
    }

    static Query[] queries = new Query[N];
    static HashMap<Integer,Integer> hashMap =  new HashMap<>();
    static int tot = 0;

    static void insert(int x) {
        if (!hashMap.containsKey(x)) {
            hashMap.put(x, ++tot);
        }
    }

    static int getkey(int x) {
        return hashMap.get(x);
    }

    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            insert(x - 1);
            insert(y);

            int z = 0;
            String op = scanner.next();
            if (op.contains("odd")) {
                z = 1;
            }
            queries[i] = new Query(x - 1, y, z);
        }

        for(int i = 1; i <= tot; i ++) {
            fa[i] = i;
        }
        for(int i = 1; i <= m; i ++) {
            int x = getkey(queries[i].l);
            int y = getkey(queries[i].r);

            int xx = find(x);
            int yy = find(y);

            if (xx == yy) {
                if ((st[x] ^ st[y]) != queries[i].ans) {
                    System.out.println(i-1);
                    return;
                }
            } else {
                fa[xx] = yy;
                st[xx] = st[x] ^st[y] ^ queries[i].ans;
            }
        }
        System.out.println(m);
    }
}
