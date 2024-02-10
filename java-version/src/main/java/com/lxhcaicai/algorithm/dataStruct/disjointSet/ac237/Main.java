package com.lxhcaicai.algorithm.dataStruct.disjointSet.ac237;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final int N = (int) (2E5 + 100);
    static int[] fa = new int[N];
    static int find(int x) {
        if(x == fa[x]) {
            return fa[x];
        }
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Node[] nodes = new Node[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for(; t > 0; t--) {
            int tot = 0;
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            int n = scanner.nextInt();
            for(int i = 1; i <= n; i ++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                if (!hashMap.containsKey(x)) {
                    hashMap.put(x, ++tot);
                }
                if (!hashMap.containsKey(y)) {
                    hashMap.put(y, ++tot);
                }
                nodes[i] = new Node(x, y, z);
            }

            for(int i = 1; i <= tot; i ++) {
                fa[i] = i;
            }

            for(int i = 1; i <= n; i ++) {
                if (nodes[i].z == 1) {
                    int x = hashMap.get(nodes[i].x);
                    int y = hashMap.get(nodes[i].y);
                    x = find(x);
                    y = find(y);
                    if (x != y) {
                        fa[x] = y;
                    }
                }
            }

            boolean ok = true;
            for(int i = 1; i <= n; i ++) {
                if (nodes[i].z == 0) {
                    int x = hashMap.get(nodes[i].x);
                    int y = hashMap.get(nodes[i].y);
                    x = find(x);
                    y = find(y);
                    if (x == y) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
