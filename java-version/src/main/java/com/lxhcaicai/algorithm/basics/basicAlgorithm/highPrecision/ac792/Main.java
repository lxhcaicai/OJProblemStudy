package com.lxhcaicai.algorithm.basics.basicAlgorithm.highPrecision.ac792;

import java.util.*;

public class Main {


    static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) {
            return A.size() > B.size();
        }
        for(int i = A.size() - 1; i >= 0; i --) {
            if (A.get(i) != B.get(i)) {
                return A.get(i) > B.get(i);
            }
        }
        return true;
    }

    static List<Integer> getNum(String str) {
        List<Integer> list = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i --) {
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    static List<Integer> sub(List<Integer> A, List<Integer> B) {
        Stack<Integer> C = new Stack<>();
        for(int i = 0, t = 0; i < A.size(); i ++) {
            t = A.get(i) - t;
            if (i < B.size()) {
                t -= B.get(i);
            }
            C.add((t + 10) % 10);
            if (t < 0) {
                t = 1;
            } else {
                t = 0;
            }
        }
        while (C.size() > 1 && C.peek() == 0) {
            C.pop();
        }
        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> A = getNum(scanner.next());
        List<Integer> B = getNum(scanner.next());
        List<Integer> C;
        if (cmp(A, B)) {
            C = sub(A,B);
        } else {
            C = sub(B, A);
            System.out.printf("-");
        }
        Collections.reverse(C);
        C.forEach(c -> {
            System.out.printf("%d",c);
        });
    }
}
