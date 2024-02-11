package com.lxhcaicai.algorithm.dataStruct.segmentTree.ac1277;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 +100);

    static class Segment {
        int l,r;
        long dat, mtag, atag;

        public Segment(int l, int r, long dat, long mtag, long atag) {
            this.l = l;
            this.r = r;
            this.dat = dat;
            this.mtag = mtag;
            this.atag = atag;
        }

        public Segment() {
        }
    }

    static Segment[] t = new Segment[N << 2];

    static int mod;
    static int[] a = new int[N];

    static void pushup(int p) {
        int lc = p << 1;
        int rc = p << 1 | 1;
        t[p].dat = (t[lc].dat + t[rc].dat) % mod;
    }

    static void spread(int p) {
        int lc = p << 1;
        int rc = p << 1 | 1;

        t[lc].dat = t[lc].dat *t[p].mtag % mod;
        t[lc].dat = (t[lc].dat + (t[lc].r - t[lc].l + 1) * t[p].atag) % mod;
        t[lc].mtag = t[lc].mtag * t[p].mtag % mod;
        t[lc].atag = (t[lc].atag * t[p].mtag + t[p].atag) % mod;


        t[rc].dat=t[rc].dat*t[p].mtag%mod;
        t[rc].dat=(t[rc].dat+(t[rc].r-t[rc].l+1)*t[p].atag)%mod;
        t[rc].mtag=t[rc].mtag*t[p].mtag%mod;
        t[rc].atag=(t[rc].atag*t[p].mtag+t[p].atag)%mod;

        t[p].mtag=1;t[p].atag=0;
    }

    static void build(int p, int l, int r) {
        t[p] = new Segment(l, r, 0, 1, 0);
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

    static void update_mul(int p, int l, int r, long val) {
        if (l <= t[p].l && t[p].r <= r) {
            t[p].dat=t[p].dat*val%mod;
            t[p].mtag=t[p].mtag*val%mod;
            t[p].atag=t[p].atag*val%mod;
            return;
        }
        spread(p);
        int lc = p << 1;
        int rc = p << 1 | 1;
        int mid = (t[p].l + t[p].r) >> 1;
        if (l <= mid) {
            update_mul(lc, l, r, val);
        }
        if (r > mid) {
            update_mul(rc, l, r, val);
        }
        pushup(p);
    }

    static void update_add(int p, int l, int r, long val) {
        if (l <= t[p].l && t[p].r <= r) {
            t[p].dat = (t[p].dat + (t[p].r - t[p].l + 1) * val) % mod;
            t[p].atag = (t[p].atag + val) % mod;
            return;
        }
        spread(p);
        int lc = p << 1;
        int rc = p << 1 | 1;
        int mid = (t[p].l + t[p].r) >> 1;
        if (l <= mid) {
            update_add(lc, l, r, val);
        }
        if (r > mid) {
            update_add(rc, l, r, val);
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
        return sum % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        mod = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        build(1, 1, n);
        for(int m = scanner.nextInt(); m > 0; m --) {
            int op = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int val;
            if (op == 1) {
                val = scanner.nextInt();
                update_mul(1, l, r, val);
            } else if (op == 2) {
                val = scanner.nextInt();
                update_add(1, l, r, val);
            } else {
                System.out.println(query(1, l, r));
            }
        }
    }
}
