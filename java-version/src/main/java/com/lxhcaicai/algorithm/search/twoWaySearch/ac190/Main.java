package com.lxhcaicai.algorithm.search.twoWaySearch.ac190;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int N = 20;
    static int n;

    static String[] a = new String[N];
    static String[] b = new String[N];
    static String A, B;

    static int extend(Queue<String> queue, HashMap<String, Integer> da, HashMap<String, Integer> db, String a[], String b[]) {
        int d = da.get(queue.peek());
        while (queue.size() > 0 &&da.get(queue.peek()) == d) {
            String t = queue.peek(); queue.poll();

            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < t.length(); j ++) {
                    if(a[i].length() + j <= t.length() && t.substring(j, j + a[i].length()).equals(a[i])) {
                        String r = t.substring(0, j) + b[i] + t.substring(j +  a[i].length());
                        if(db.containsKey(r)) return db.get(r) + da.get(t) + 1;
                        if(da.containsKey(r)) continue;
                        da.put(r, da.get(t)+1);
                        queue.add(r);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static int bfs() {
        if (A.equals(B)) {
            return  0;
        }
        Queue<String> qa = new LinkedList<>();
        Queue<String> qb = new LinkedList<>();
        HashMap<String,Integer> da = new HashMap<>();
        HashMap<String, Integer> db = new HashMap<>();

        qa.add(A);
        qb.add(B);
        da.put(A,0);
        db.put(B,0);
        int step = 0;
        while (qa.size() > 0 && qb.size() > 0) {
            int t;
            if (qa.size() <qb.size()) {
                t = extend(qa,da,db, a, b);
            } else {
                t = extend(qb,db,da,b,a);
            }
            if (t <= 10) {
                return t;
            }
            if ( ++ step > 10) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.next();
        B = scanner.next();
        while (scanner.hasNext()) {
            a[n] = scanner.next();
            b[n] = scanner.next();
            n ++;
        }
        int t = bfs();
        if(t == -1) {
            System.out.println("NO ANSWER!");
        } else {
            System.out.println(t);
        }
    }
}
