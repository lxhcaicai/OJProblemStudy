package com.lxhcaicai.algorithm.basics.mathKnowledge.gametheory.ac894;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static final int N = 110;
    static int[] f = new int[N];
    static int m;
    static int sg(int x) {
        if (f[x] !=  -1) {
            return f[x];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < x; i ++) {
            for(int j = 0; j <= i; j ++) {
                set.add(sg(i) ^ sg(j));
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
