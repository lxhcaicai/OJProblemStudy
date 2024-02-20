package com.lxhcaicai.algorithm.basics.basicAlgorithm.discretization.ac802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    static final int N = (int) (4e5 + 100);

    static int tot = 0;
    static int[] a = new int[N];
    static long[] sum = new long[N];

    static int find(int x) {
        int pos = 1;
        int l = 1, r = tot;
        while ( l<=r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= x) {
                r = mid - 1;
                pos = mid;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    static class Node {
        int first, second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static List<Node> list = new ArrayList<>();
    static List<Node> queryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int cnt = 0;
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            a[++cnt] = x;
            list.add(new Node(x, c));
        }

        for(int i = 1; i <= m; i ++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            a[++cnt] = l;
            a[++cnt] = r;
            queryList.add(new Node(l, r));
        }

        Arrays.sort(a, 1, cnt + 1);
        tot = 1;
        for(int i = 1; i <= cnt; i ++) {
            if (a[tot] == a[i]) {
                continue;
            }
            a[++tot] = a[i];
        }

        for(Node no: list) {
            int x = find(no.first);
            int c = no.second;
            sum[x] += c;
        }

        for(int i = 1; i <= tot; i ++) {
            sum[i] += sum[i - 1];
        }

        for(Node no: queryList) {
            int l = find(no.first);
            int r = find(no.second);
            System.out.println(sum[r] - sum[l - 1]);
        }
    }
}
