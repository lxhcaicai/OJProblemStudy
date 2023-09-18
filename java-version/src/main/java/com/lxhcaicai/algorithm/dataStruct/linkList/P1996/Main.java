package com.lxhcaicai.algorithm.dataStruct.linkList.P1996;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// P1996 约瑟夫问题
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i ++) {
            queue.add(i);
        }
        while (queue.size() > 0) {
            for (int i = 1; i < m; i ++) {
                // poll return head element and move
                queue.add(queue.poll());
            }
            System.out.printf("%d ", queue.poll());
        }
    }
}
