package com.lxhcaicai.algorithm.search.dfsPruningOptimization.ac168;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);
    static final int INF = (int) 1e9;
    static int[] minv = new int[N];
    static int[] mins = new int[N];
    static int[] H = new int[N];
    static int[] R = new int[N];
    static int ans = 0;
    static int n, m;

    static void dfs(int d, int v, int s) {
        if (v + minv[d] > n) {
            return;
        }
        if (s + mins[d] >= ans) {
            return;
        }
        if (s + 2 *(n -v)/R[d + 1] >= ans ) {
            return;
        }
        if (d == 0) {
            if (n == v) {
                ans = s;
            }
            return;
        }

        for(int r=Math.min((int)Math.sqrt(n-v),R[d+1]-1);r>=d;r--){
            for(int h=Math.min((int)(n-v)/(r*r),H[d+1]-1);h>=d;h--){
                int t=0;
                if(d==m) t=r*r;
                H[d]=h;R[d]=r;
                dfs(d-1,v+r*r*h,s+2*r*h+t);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= m; i ++) {
            minv[i] = minv[i-1] + i*i*i;
            mins[i] = mins[i - 1] + 2 *i *i;
        }
        H[m + 1] =INF;
        R[m + 1] = INF;
        ans = INF;
        dfs(m, 0, 0);
        System.out.println((ans == INF ? 0: ans));
    }
}
