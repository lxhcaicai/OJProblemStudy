package com.lxhcaicai.algorithm.basics.dynamicPlanning.countDp.ac338;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int get(List<Integer> num,int l, int r) {
        int res = 0;
        for(int i = l ; i >= r; i --) {
            res = res * 10 + num.get(i);
        }
        return res;
    }

    static int power10(int i) {
        int res = 1;
        while (i -- > 0) {
            res *= 10;
        }
        return res;
    }

    static int count(int n, int x) {
        List<Integer> num = new ArrayList<>();
        while (n != 0) {
            num.add(n % 10);
            n /= 10;
        }
        n = num.size();
        int res = 0;
        //这里需要注意，我们的长度需要减一，是因为num是从0开始存储，而长度是元素的个数，
        // 因此需要减1才能读到正确的数值，而！x出现的原因是因为我们不能让前导零出现，
        // 如果此时需要我们列举的是0出现的次数，那么我们自然不能让他出现在第一位，而是从第二位开始枚举
        for(int i = n - 1 - (x == 0?1:0) ; i >= 0; i --) {
            // 其实这里可以不用if判断，因为for里面实际上就已经达成了if的判断，但为了方便理解还是加上if来理解，
            // 这里i要小于n-1的原因是因为我们不能越界只有7位数就最高从七位数开始读起
            if (i < n - 1) {
                // 000~abc-1,那么此时情况个数就会是abc*10^3，这里的3取决于后面efg的长度，假如他是efgh，那么就是4
                res += get(num, n - 1, i + 1) * power10(i);
                if (x == 0) {
                    //假如此时我们要列举的是0出现的次数，因为不能出现前导零，这样是不合法也不符合我们的分类情况，
                    // 例如abcdefg我们列举d，那么他就得从001~abc-1，这样就不会直接到efg，而是会到0efg，
                    // 因为前面不是前导零，自然就可以列举这个时候0出现的次数，所以要减掉1个power10
                    res -= power10(i);
                }
            }
            // //剩下的这两个就直接根据分类标准来就好了
            if (num.get(i) == x) {
                res += get(num, i - 1, 0) + 1;
            } if (num.get(i) > x) {
                res += power10(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a= scanner.nextInt();
            int b = scanner.nextInt();
            if (a ==0 && b == 0) {
                return;
            }
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            for(int i = 0 ; i <= 9; i ++) {
                System.out.printf(count(b, i) - count(a-1,i) + " ");
            }
            System.out.println();
        }
    }
}
