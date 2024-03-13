package com.lxhcaicai.algorithm.basics.datastruct.stack.ac830;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n; i ++) {
            int x = scanner.nextInt();
            while (stack.size() > 0 && stack.peek() >= x) {
                stack.pop();
            }
            if (stack.size() == 0) {
                System.out.printf("-1 ");
            } else {
                System.out.printf(stack.peek() + " ");
            }
            stack.push(x);
        }

    }
}
