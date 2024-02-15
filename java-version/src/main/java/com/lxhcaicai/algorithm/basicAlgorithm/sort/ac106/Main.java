package com.lxhcaicai.algorithm.basicAlgorithm.sort.ac106;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static void solve() {
        int id = scanner.nextInt();
        int n = scanner.nextInt();

        PriorityQueue<Integer> maxQue = new PriorityQueue<>((a,b) ->(b-a));
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            int num = scanner.nextInt();
            maxQue.add(num);
            while (maxQue.size() - 1 > minQue.size()) {
                int x = maxQue.peek(); maxQue.poll();
                minQue.add(x);
            }
            while (minQue.size() > 0 && maxQue.peek() > minQue.peek()) {
                int x= maxQue.peek(); maxQue.poll();
                int y= minQue.peek(); minQue.poll();
                maxQue.add(y);
                minQue.add(x);
            }
            if((i & 1) == 1) list.add(maxQue.peek());
        }
        System.out.println(id + " " + list.size());
        int cnt = 0;
        for(int x: list) {
            cnt ++;
            System.out.printf(x + " ");
            if (cnt % 10 == 0) {
                System.out.println();
            }
        }
        if (cnt % 10 != 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        for(int t = scanner.nextInt(); t > 0; t --) {
            solve();
        }
    }
}
