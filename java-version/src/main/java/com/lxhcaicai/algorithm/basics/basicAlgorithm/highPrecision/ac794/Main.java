package com.lxhcaicai.algorithm.basics.basicAlgorithm.highPrecision.ac794;

import java.util.*;

public class Main {

    static List<Integer> getNum(String str) {
        List<Integer> list = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i --) {
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    static Integer div(List<Integer> A, Integer B) {
        Stack<Integer> C = new Stack<>();
        Integer R = 0;
        for(int i = A.size() - 1; i >= 0; i --)  {
            R = R * 10 + A.get(i);
            C.add(R / B);
            R %= B;
        }
        Collections.reverse(C);
        while (C.size() > 1 && C.peek() == 0) {
            C.pop();
        }
        Collections.reverse(C);
        C.forEach(c -> {
            System.out.printf("%d",c);
        });
        return R;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> A = getNum(scanner.next());
        Integer B = scanner.nextInt();
        Integer R = div(A, B);
        System.out.println("\n" + R);
    }
}
