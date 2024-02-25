package com.lxhcaicai.algorithm.basics.mathKnowledge.approximateNumber.ac871;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Integer,Integer> countMap = new HashMap<>();
    static final int MOD = (int) (1E9 + 7);

    static void insert(int x, int num) {
        if (countMap.containsKey(x)) {
            countMap.put(x, countMap.get(x) + num);
        } else {
            countMap.put(x, num);
        }
    }

    static void getDiv(int x) {
        for(int i = 2; (long) i * i <= x; i ++) {
            if (x % i == 0) {
                int cnt = 0;
                while (x % i == 0) {
                    x /= i;
                    cnt ++;
                }
                insert(i, cnt);
            }
        }
        if (x > 1) {
            insert(x, 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            getDiv(x);
        }
        long ans = 1;
        for(Map.Entry<Integer,Integer> entry: countMap.entrySet()) {
            long a = entry.getKey();
            long b = entry.getValue();
            long t = 1;
            while (b -- > 0) {
                t = (t * a  + 1) % MOD;
            }
            ans = ans * t % MOD;
        }
        System.out.println(ans);
    }
}
