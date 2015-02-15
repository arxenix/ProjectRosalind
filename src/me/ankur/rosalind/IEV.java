package me.ankur.rosalind;

import java.util.Scanner;

/**
 * Created by Sundara on 1/18/15.
 */
public class IEV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(2 * (sc.nextInt() + sc.nextInt() + sc.nextInt() + 0.75 * sc.nextInt() + 0.5 * sc.nextInt()));
        sc.close();
    }
}
