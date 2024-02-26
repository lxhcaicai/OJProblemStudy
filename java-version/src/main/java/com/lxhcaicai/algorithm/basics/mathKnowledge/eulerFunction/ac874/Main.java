package com.lxhcaicai.algorithm.basics.mathKnowledge.eulerFunction.ac874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = (int) (1e6 + 100);
    static boolean[] vis = new boolean[N];
    static List<Integer> primes = new ArrayList<>();
    static int[] phi = new int[N];

    static void getPrime(int n) {
        phi[1] = 1;
        for(int i = 2; i <= n; i ++) {
            if (!vis[i]) {
                phi[i] = i - 1;
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && (long)i * primes.get(j) <= n; j ++) {
                vis[i * primes.get(j)] = true;
                if(i % primes.get(j) == 0) {

                    /*
                当p[j]是i的一个约数时,i的质因数与p[j]*i的质因数完全相同。
                i      = (p1^a1)*(p2^a2)*(p3^a3)*...(p[j]^ap[j])...(pk^ak)
                i*p[j] = (p1^a1)*(p2^a2)*(p3^a3)*...(p[j]^(ap[j]+1))...(pk^ak)
                由欧拉函数的定义可知：
                Φ(i)      =  i   * (1-1/p1)*(1-1/p2)*(1-1/p3)*...(1-1/p[j])*...(1-1/pk)
                Φ(i*p[j]) = i*p[j]*(1-1/p1)*(1-1/p2)*(1-1/p3)*...(1-1/p[j])*...(1-1/pk)
                */

                    phi[i * primes.get(j)] = phi[i] * primes.get(j);
                    break;
                } else {
            /*
            当i%p[j]!=0时，p[j]不是i的约数，i与i*p[j]的质因子相差一个p[j]
            i      = (p1^a1)*(p2^a2)*(p3^a3)*...(pk^ak)
            i*p[j] = (p1^a1)*(p2^a2)*(p3^a3)*...(pk^ak)*(p[j]^ap[j])
            所以由欧拉函数的定义可知：
            Φ(i)      =  i    *(1-1/p1)*(1-1/p2)*(1-1/p3)*...(1-1/pk)
            Φ(i*p[j]) = i*p[j]*(1-1/p1)*(1-1/p2)*(1-1/p3)*...(1-1/pk)(1-1/p[j])
            */

                    phi[i * primes.get(j)] = phi[i] * (primes.get(j) - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrime(n);
        long res = 0;
        for(int i = 1; i <= n; i ++) {
            res += phi[i];
        }
        System.out.println(res);
    }
}
