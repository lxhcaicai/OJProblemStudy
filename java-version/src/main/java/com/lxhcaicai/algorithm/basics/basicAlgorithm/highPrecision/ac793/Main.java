package com.lxhcaicai.algorithm.basics.basicAlgorithm.highPrecision.ac793;

import java.util.*;

public class Main {

    static List<Integer> getNum(String str) {
        List<Integer> list = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i --) {
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    static List<Integer> mul(List<Integer> A, Integer B) {
        Stack<Integer> C = new Stack<>();
        for(int i = 0, t = 0; i < A.size() || t > 0; i ++) {
            if (i < A.size()) {
                t += A.get(i) * B;
            }
            C.add(t % 10);
            t /= 10;
        }
        while (C.size() > 1 && C.peek() == 0) {
            C.pop();
        }
        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> A = getNum(scanner.next());
        Integer B = scanner.nextInt();
        List<Integer> C = mul(A,B);
        Collections.reverse(C);
        C.forEach(c -> {
            System.out.printf("%d",c);
        });
    }
}
