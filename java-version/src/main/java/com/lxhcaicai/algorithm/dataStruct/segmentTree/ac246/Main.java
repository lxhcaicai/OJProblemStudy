package com.lxhcaicai.algorithm.dataStruct.segmentTree.ac246;

import java.util.Scanner;

public class Main {

    static final int N = (int) (5e5 + 100);

    static class Segment {
        int l, r;
        long dat;

        public Segment(int l, int r, long dat) {
            this.l = l;
            this.r = r;
            this.dat = dat;
        }

        public Segment() {
        }
    }

    static Segment[] t = new Segment[N << 2];

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    static long[] a = new long[N];
    static long[] b = new long[N];

    static void build(int p, int l, int r) {
        t[p] = new Segment();
        t[p].l = l; t[p].r =r;
        if (l== r) {
            t[p].dat = b[l];
            return;
        }
        int mid = (t[p].l + t[p].r) >> 1;
        int lc = p << 1;
        int rc = p << 1 | 1;
        build(lc, l, mid);
        build(rc, mid + 1, r);
        pushup(p);
    }

    static void pushup(int p) {
        int lc = p << 1;
        int rc = p << 1 |1;
        t[p].dat = gcd(t[lc].dat, t[rc].dat);
    }

    static void update(int p, int x, long val) {
        if (t[p].l == t[p].r) {
            t[p].dat += val;
            return;
        }
        int mid = (t[p].l + t[p].r) >> 1;
        int lc = p << 1;
        int rc = p << 1 |1;
        if (x <= mid) {
            update(lc, x, val);
        }
        if (x > mid) {
            update(rc, x, val);
        }
        pushup(p);
    }

    static long query(int p, int l, int r) {
        if (l <= t[p].l && t[p].r <= r) {
            return t[p].dat;
        }
        int mid = (t[p].l + t[p].r) >> 1;
        int lc = p << 1;
        int rc = p << 1 |1;
        long val = 0;
        if (l <= mid) {
            val = gcd(val, query(lc, l, r));
        }
        if (r > mid) {
            val = gcd(val, query(rc, l, r));
        }
        return Math.abs(val);
    }

    static int n, m;
    static long[] c = new long[N];

    static void add(int x, long val) {
        for(; x <= n; x += x&-x) {
            c[x] += val;
        }
    }

    static long ask(int x) {
        long res = 0;
        for(; x > 0; x -= x&-x) {
            res += c[x];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextLong();
            b[i] = a[i] - a[i-1];
            add(i, b[i]);
        }
        build(1,1, n);
        while (m -- !=0) {
            String op = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (op.charAt(0) =='C') {
                long d = scanner.nextLong();
                add(x, d);
                update(1, x, d);
                if (y < n) {
                    add(y + 1, -d);
                    update(1, y + 1, -d);
                }
            } else {
                long ans1 = ask(x);
                long ans2 = query(1, x + 1, y);
                System.out.println(gcd(ans1, ans2));
            }
        }
    }
}
