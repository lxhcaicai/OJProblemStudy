package com.lxhcaicai.algorithm.dataStruct.binaryIndexTrees.ac244;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static int[] c = new int[N];

    static int n;
    static void add(int x, int val) {
        for(; x <= n; x += x&-x) {
            c[x] += val;
        }
    }

    static int query(int x) {
        int res = 0;
        for(; x > 0; x -= x&-x) {
            res += c[x];
        }
        return res;
    }

    static int[] a = new int[N];
    static int[] ans = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            add(i, 1);
        }
        for(int i =2; i <= n; i ++) {
            a[i] = scanner.nextInt();
        }
        for(int i = n; i >= 1; i --) {
            int l = 1, r = n;
            int res = l;
            while( l <= r) {
                int mid = (l + r) >> 1;
                if (query(mid) >= a[i] + 1) {
                    r = mid - 1;
                    res = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = res;
            add(res, - 1);
        }
        for(int i = 1; i <= n; i ++) {
            System.out.println(ans[i]);
        }
    }
}
