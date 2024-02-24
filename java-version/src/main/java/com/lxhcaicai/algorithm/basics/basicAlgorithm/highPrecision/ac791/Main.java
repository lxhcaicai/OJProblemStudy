package com.lxhcaicai.algorithm.basics.basicAlgorithm.highPrecision.ac791;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> add(List<Integer> A, List<Integer> B) {
        if (A.size() < B.size()) {
            return add(B,A);
        }
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < A.size(); i ++) {
            t += A.get(i);
            if (i < B.size()) {
                t += B.get(i);
            }
            C.add(t % 10);
            t /= 10;
        }
        if (t !=0 ) {
            C.add(t);
        }
        return C;
    }

    static List<Integer> getNum(String str) {
        List<Integer> list = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i --) {
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> A = getNum(scanner.next());
        List<Integer> B = getNum(scanner.next());
        List<Integer> C = add(A,B);
        Collections.reverse(C);
        C.forEach(c -> {
            System.out.printf("%d",c);
        });
    }
}
