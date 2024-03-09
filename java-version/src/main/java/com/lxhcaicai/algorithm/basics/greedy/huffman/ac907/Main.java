package com.lxhcaicai.algorithm.basics.greedy.huffman.ac907;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= n; i ++) {
            int x= scanner.nextInt();
            queue.add(x);
        }
        int ans = 0;
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            ans += x + y;
            queue.add(x + y);
        }
        System.out.println(ans);
    }
}
