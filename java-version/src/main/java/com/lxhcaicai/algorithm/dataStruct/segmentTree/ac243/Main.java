package com.lxhcaicai.algorithm.dataStruct.segmentTree.ac243;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static class Segment {
        int l, r;
        long dat, atag;

        public Segment() {
        }

        public Segment(int l, int r, long dat, long atag) {
            this.l = l;
            this.r = r;
            this.dat = dat;
            this.atag = atag;
        }
    }

    static int[] a = new int[N];

    static Segment[] t = new Segment[N << 2];

    static void pushup(int p) {
        int lc = p << 1;
        int rc = p << 1 | 1;
        t[p].dat=t[lc].dat+t[rc].dat;
    }

    static void spread(int p) {
        int lc = p << 1;
        int rc = p << 1 | 1;
        t[lc].dat+=(t[lc].r-t[lc].l+1)*t[p].atag;
        t[rc].dat+=(t[rc].r-t[rc].l+1)*t[p].atag;
        t[lc].atag+=t[p].atag;
        t[rc].atag+=t[p].atag;
        t[p].atag=0;
    }

    static void build(int p, int l, int r) {
        t[p] = new Segment(l, r, 0, 0);
        if (l == r) {
            t[p].dat = a[l];
            return;
        }
        int lc = p << 1;
        int rc = p << 1 | 1;
        int mid = (t[p].l + t[p].r) >> 1;
        build(lc, l, mid);
        build(rc, mid + 1, r);
        pushup(p);
    }

    static void update(int p, int l, int r, int val) {
        if (l <= t[p].l && t[p].r <= r) {
            t[p].dat += (t[p].r - t[p].l + 1) * val;
            t[p].atag += val;
            return;
        }
        spread(p);
        int lc = p << 1;
        int rc = p << 1 | 1;
        int mid = (t[p].l + t[p].r) >> 1;
        if (l <= mid) {
            update(lc, l, r, val);
        }
        if (r > mid) {
            update(rc, l, r, val);
        }
        pushup(p);
    }

    static long query(int p, int l, int r) {
        if (l <= t[p].l && t[p].r <= r) {
            return t[p].dat;
        }
        spread(p);
        long sum = 0;
        int lc = p << 1;
        int rc = p << 1 | 1;
        int mid = (t[p].l + t[p].r) >> 1;
        if (l <= mid) {
            sum += query(lc, l, r);
        }
        if (r > mid) {
            sum += query(rc, l, r);
        }
        return sum;
    }

    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1;  i<= n; i ++) {
            a[i] = scanner.nextInt();
        }
        build(1, 1, n);
        for(; m > 0; m --) {
            String op = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (op.contains("Q")) {
                System.out.println(query(1,x, y));
            } else {
                int d = scanner.nextInt();
                update(1, x, y, d);
            }
        }
    }
}
