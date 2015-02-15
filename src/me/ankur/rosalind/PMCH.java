package me.ankur.rosalind;

import me.ankur.rosalind.util.MathUtil;

import java.util.Scanner;

/**
 * Created by Sundara on 2/15/15.
 */
public class PMCH {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna = sc.nextLine();
        sc.close();

        int a = 0;
        int c = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A') a++;
            else if (dna.charAt(i) == 'C') c++;
        }

        System.out.println(MathUtil.bigFactorial(a).multiply(MathUtil.bigFactorial(c)));
    }
}
