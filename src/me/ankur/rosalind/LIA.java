package me.ankur.rosalind;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by Sundara on 12/20/14.
 */
public class LIA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(independence(k, n));
    }

    public static BigDecimal prob(int s, double p, int n) {
        double x = 1.0 - p;
        int a = n - s;
        int b = s + 1;
        int c = a + b - 1;


        BigDecimal prob = BigDecimal.ZERO;
        for (int i = a; i < c + 1; i++) {
            prob = prob.add(fac(c).divide(fac(i).multiply(fac(c - i)), RoundingMode.UP).multiply(BigDecimal.valueOf(x).pow(i)).multiply(BigDecimal.valueOf(1 - x).pow(c - i)));
        }
        return prob;
    }

    public static BigDecimal independence(int k, int n) {
        return BigDecimal.ONE.subtract(prob(n - 1, 0.25, (int) Math.pow(2, k)));
    }

    public static BigDecimal fac(int n) {
        BigDecimal fact = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigDecimal.valueOf(i));
        }
        return fact;
    }
}
