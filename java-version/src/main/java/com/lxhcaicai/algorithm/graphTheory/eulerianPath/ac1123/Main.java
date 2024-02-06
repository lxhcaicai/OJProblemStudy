package com.lxhcaicai.algorithm.graphTheory.eulerianPath.ac1123;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x1,x2, y1,y2;
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        double sum = 0;
        while (scanner.hasNext()) {
            x1 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            y2 = scanner.nextDouble();

            double dx = x1 -x2;
            double dy = y1 - y2;
            sum += Math.sqrt(dx * dx + dy * dy) * 2;
        }

        int minutes = (int) Math.round(sum / 1000/20 * 60);
        int hours = minutes / 60;
        minutes %= 60;
        System.out.printf("%d:%02d", hours, minutes);
    }
}
