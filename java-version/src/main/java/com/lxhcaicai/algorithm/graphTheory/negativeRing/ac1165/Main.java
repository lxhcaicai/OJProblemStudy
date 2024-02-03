package com.lxhcaicai.algorithm.graphTheory.negativeRing.ac1165;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// AcWing 1165. 单词环
public class Main {
    static final int N = 700;
    static final int M = (int) (1E5 + 100);

    static int[] head = new int[N];
    static int[] ver = new int[M];
    static int[] nex = new int[M];
    static int[] edge = new int[M];
    static int tot = 0;
    static void addedge(int x, int y, int z) {
        ver[ ++ tot] = y;
        nex[tot] = head[x];
        head[x] = tot;
        edge[tot] = z;
    }
    static int n;
    static double[] dis = new double[N];
    static int[] cnt = new int[N];
    static boolean[] in = new boolean[N];

    static boolean check(double mid) {
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(cnt, 0);
        Arrays.fill(dis, 0);
        for(int i = 0; i <= 26 * 26; i ++) {
            in[i] = true;
            stack.push(i);
        }
        while (stack.size() > 0) {
            int x = stack.peek();
            stack.pop();
            in[x] = false;
            for(int i = head[x]; i != 0; i = nex[i]) {
                int y = ver[i];
                double w = mid - edge[i];
                if (dis[y] > dis[x] + w) {
                    dis[y] = dis[x] + w;
                    cnt[y] = cnt[x] + 1;
                    if (cnt[y] > N) {
                        return true;
                    }
                    if(!in[y]) {
                        stack.add(y);
                        in[y] = true;
                    }
                }
            }
        }
        return false;
    }

    static String[] ss = new String[M];
    static int HashCode(String str) {
        int res = 0;
        for(int i = 0; i < str.length(); i ++) {
            res = res * 26 + (str.charAt(i) - 'a');
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            Arrays.fill(head, 0);
            tot = 0;
            scanner.nextLine();
            for(int i = 1; i <= n; i ++) {
                ss[i] = scanner.nextLine();
                int len = ss[i].length();
                int x = HashCode(ss[i].substring(0, 2));
                int y = HashCode(ss[i].substring(len -2, len));
                addedge(x, y, len);
            }

            if (!check(0)) {
                System.out.println("No solution");
                continue;
            }
            double l = 0, r = 1000;
            final double eps = 1e-5;
            while (Math.abs(l - r) > eps) {
                double mid = (l  + r)/2;
                if(check(mid)) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            System.out.printf("%.2f\n", l);
        }
    }
}
