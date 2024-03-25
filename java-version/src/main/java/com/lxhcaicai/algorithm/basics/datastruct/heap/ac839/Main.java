package com.lxhcaicai.algorithm.basics.datastruct.heap.ac839;

import java.util.Scanner;

public class Main {

    static final int N = (int) (1E5 + 100);

    static int[] h = new int[N];
    static int[] ph = new int[N];
    static int[] hp = new int[N];
    static int cnt;

    static void head_swap(int a, int b) {
        {
            int tmp = ph[hp[a]];
            ph[hp[a]] = ph[hp[b]];
            ph[hp[b]] = tmp;
        }

        {
            int tmp = hp[a];
            hp[a] = hp[b];
            hp[b] = tmp;
        }

        {
            int tmp = h[a];
            h[a] = h[b];
            h[b] = tmp;
        }
    }

    static void down(int u) {
        int t = u;
        if (u * 2 <= cnt && h[u * 2] < h[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= cnt && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        if (u != t) {
            head_swap(u, t);
            down(t);
        }
    }

    static void up(int u) {
        while (u / 2 != 0 && h[u] < h[u/2]) {
            head_swap(u, u / 2);
            u >>= 1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 0;
        while (n -- > 0) {

            String op = scanner.next();
            int k, x;
            if (op.equals("I")) {
                x = scanner.nextInt();
                cnt ++;
                m ++;
                ph[m] = cnt; hp[cnt] = m;
                h[cnt] = x;
                up(cnt);
            } else if (op.equals("PM")) {
                System.out.println(h[1]);
            } else if (op.equals("DM")) {
                head_swap(1, cnt);
                cnt --;
                down(1);
            } else if (op.equals("D")) {
                k = scanner.nextInt();
                k = ph[k];
                head_swap(k, cnt);
                cnt --;
                up(k);
                down(k);
            } else {
                k = scanner.nextInt();
                x = scanner.nextInt();
                k = ph[k];
                h[k] = x;
                up(k);
                down(k);
            }
        }
    }
}
