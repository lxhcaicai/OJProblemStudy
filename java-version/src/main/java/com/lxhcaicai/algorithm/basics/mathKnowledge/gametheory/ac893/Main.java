package com.lxhcaicai.algorithm.basics.mathKnowledge.gametheory.ac893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static final int N = 110;
    static int[] s = new int[N];
    static int[] f = new int[N*100];
    static int m;
    static int sg(int x) {
        if (f[x] !=  -1) {
            return f[x];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= m; i ++) {
            if (x >= s[i]) {
                set.add(sg(x - s[i]));
            }
        }
        for(int i = 0; ; i ++) {
            if (!set.contains(i)) {
                f[x] = i;
                return f[x];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            s[i] = scanner.nextInt();
        }

        Arrays.fill(f, -1);
        int n = scanner.nextInt();
        int ans = 0;
        while (n -- > 0) {
            int x = scanner.nextInt();
            ans ^= sg(x);
        }
        if (ans != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
