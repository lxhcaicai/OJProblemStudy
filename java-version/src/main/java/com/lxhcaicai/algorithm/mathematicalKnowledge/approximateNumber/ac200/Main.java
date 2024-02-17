package com.lxhcaicai.algorithm.mathematicalKnowledge.approximateNumber.ac200;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e5 + 100);

    static List<Integer> primes = new ArrayList<>();
    static boolean[] vis = new boolean[N];

    static void getPrime(int n) {
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static class Factor {
        int num;
        int cnt;

        public Factor(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    static Factor[] factors = new Factor[N];
    static int tot = 0;

    static void getFactor(int n) {
        tot = 0;
        for(int j = 0; j < primes.size() && primes.get(j) * primes.get(j) <= n; j ++) {
            int p = primes.get(j);
            if (n % p == 0) {
                int cnt = 0;
                while (n % p == 0) {
                    cnt ++;
                    n /= p;
                }
                factors[++ tot] = new Factor(p, cnt);
            }
        }
        if(n > 1) {
            factors[++ tot] = new Factor(n, 1);
        }
    }

    static int a0, a1, b0, b1;

    static int ans = 0;

    static void dfs(int d, int s) {
        if (d > tot) {
            if (gcd(s, a0) == a1 && (long) s * b0 /gcd(s, b0) == b1)  {
                ans ++;
            }
            return;
        }
        for(int i = 0; i <= factors[d].cnt; i ++) {
            dfs(d + 1, s);
            s *= factors[d].num;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getPrime(N - 1);
        int T = scanner.nextInt();
        while (T -- > 0) {
            a0 = scanner.nextInt();
            a1 = scanner.nextInt();
            b0 = scanner.nextInt();
            b1 = scanner.nextInt();
            ans = 0;
            getFactor(b1);
            dfs(1,1);
            System.out.println(ans);
        }
    }
}
