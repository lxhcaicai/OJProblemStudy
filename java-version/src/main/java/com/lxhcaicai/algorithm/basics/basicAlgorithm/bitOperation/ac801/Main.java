package com.lxhcaicai.algorithm.basics.basicAlgorithm.bitOperation.ac801;

import java.util.Scanner;

public class Main {

    static int get(int x) {
        int ans = 0;
        for(int i = 31; i >= 0; i --) {
            if (((x >> i ) & 1) ==1) {
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i ++) {
            int x  = scanner.nextInt();
            System.out.printf(get(x) + " ");
        }
    }
}
