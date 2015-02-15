package me.ankur.rosalind;

import me.ankur.rosalind.util.MathUtil;

import java.util.Scanner;

/**
 * Created by Sundara on 2/15/15.
 */
public class PROB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna = sc.nextLine();

        String[] counts = sc.nextLine().split(" ");
        double[] a = new double[counts.length];
        for (int i = 0; i < counts.length; i++) {
            a[i] = Double.parseDouble(counts[i]);
        }

        for (double gc : a) {
            double prob = 1.0;
            for (char c : dna.toCharArray()) {
                switch (c) {
                    case 'A':
                    case 'T':
                        prob *= (1 - gc) * 0.5;
                        break;
                    case 'C':
                    case 'G':
                        prob *= gc * 0.5;
                }
            }
            System.out.print(MathUtil.round(Math.log10(prob), 3).toString() + " ");
        }
        System.out.println();
    }
}
