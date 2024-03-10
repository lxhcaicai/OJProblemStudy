package com.lxhcaicai.algorithm.basics.datastruct.hashTable.ac841;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);
    static final int P = 131;

    static long[] f = new long[N];
    static long[] p = new long[N];

    // Java 没有无符号整数， 手动模拟无符号整数
    static long unsignedLong = 0xFFFFFFFFL;
    static long getUnsignedLong(long x) {
        return x & unsignedLong;
    }

    static long get(int l, int r) {
        return getUnsignedLong(f[r] - getUnsignedLong(f[l - 1] * p[r - l + 1]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String str = scanner.next();
        str = " " + str;
        p[0] = 1;
        for(int i = 1; i <= n; i ++) {
            f[i] = getUnsignedLong(getUnsignedLong(f[i - 1] * P) + str.charAt(i));
            p[i] = getUnsignedLong(p[i-1] * P);
        }

        while (m -- > 0) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            if (get(l1, r1) == get(l2, r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
