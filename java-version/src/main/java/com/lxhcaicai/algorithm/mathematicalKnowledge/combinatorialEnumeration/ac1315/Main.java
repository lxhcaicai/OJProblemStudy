package com.lxhcaicai.algorithm.mathematicalKnowledge.combinatorialEnumeration.ac1315;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 +100);

    static int[] a = new int[N];
    static int[] b = new int[N];
    static List<Integer> primes = new ArrayList<>();
    static boolean[] vis = new boolean[N];

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && (long) i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static int get(int n, int p) {
        int res = 0;
        while (n !=0) {
            res += n/p;
            n /=p;
        }
        return res;
    }

    static int mul(int r[], int len, int x) {
        int t = 0;
        for(int i = 0; i < len; i ++) {
            t += r[i] * x;
            r[i] = t % 10;
            t /= 10;
        }
        while (t !=0) {
            r[len ++] = t % 10;
            t /= 10;
        }
        return len;
    }

    static int C(int x, int y, int r[]) {
        int len = 1;
        r[0] = 1;
        for(int p: primes) {
            int s = get(x, p) - get(y, p) - get(x - y,p);
            while (s -- > 0) {
                len = mul(r, len , p);
            }
        }
        return len;
    }

    static void sub(int a[], int alen, int b[], int blen) {
        for(int i = 0, t = 0; i < alen; i ++) {
            a[i] -= t + b[i];
            if (a[i] < 0) {
                a[i] += 10;
                t = 1;
            } else {
                t = 0;
            }
        }
    }

    public static void main(String[] args) {
        getPrime(N - 1);
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int alen = C(n + m,m,a);
        int blen= C(n +m, m - 1, b);
        sub(a, alen, b, blen);
        int k = alen - 1;
        while(a[k] == 0) {
            k --;
        }
        for(int i = k; i >= 0; i --) {
            System.out.printf("%d", a[i]);
        }
    }
}
