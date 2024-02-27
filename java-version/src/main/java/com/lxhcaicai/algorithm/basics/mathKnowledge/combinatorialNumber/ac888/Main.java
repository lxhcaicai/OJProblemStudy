package com.lxhcaicai.algorithm.basics.mathKnowledge.combinatorialNumber.ac888;

import java.util.*;

public class Main {

    static final int N = 5510;
    static List<Integer> primes = new ArrayList<>();
    static int[] sum = new int[N];
    static boolean[] vis = new boolean[N];

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() & (long) i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static int get(int n,int p) {
        int ans = 0;
        while (n != 0) {
            ans += n / p;
            n /= p;
        }
        return ans;
    }

    static List<Integer> mul(List<Integer> list, int b) {
        List<Integer> result = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < list.size();i ++) {
            t += list.get(i) * b;
            result.add(t % 10);
            t /= 10;
        }
        while ( t != 0) {
            result.add(t % 10);
            t /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        getPrime(a);

        for(int i = 0; i < primes.size(); i ++) {
            int p = primes.get(i);
            sum[i] = get(a, p) - get(a-b, p) - get(b, p);
        }

        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 0; i < primes.size(); i ++) {
            int p = primes.get(i);
            for(int j = 0; j < sum[i]; j ++) {
                res = mul(res, p);
            }
        }

        Collections.reverse(res);
        res.forEach(e -> System.out.printf(e+""));
    }
}
