package me.ankur.rosalind;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sundara on 12/19/14.
 */
public class FIBD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of months
        int m = sc.nextInt();//life of rabbit
        sc.close();

        System.out.println(fibd(n, m).toString());
    }


    /*
    A(n) = B(n-1) + A(n-1) - A(n-m-1) subtract the ones that died m-1 generations ago
    B(n) = A(n-1)
    A(n) = A(n-2)+A(n-1)-A(n-m-1)
     */

    public static BigInteger fibd(int n, int m) {
        List<BigInteger> gens = new ArrayList<BigInteger>() {{
            add(BigInteger.ONE);
            add(BigInteger.ONE);
        }};
        while (gens.size() < n) {
            if (gens.size() < m)
                gens.add(gens.get(gens.size() - 2).add(gens.get(gens.size() - 1))); //F(n-2)+F(n-1)
            else if (gens.size() == m || gens.size() == m + 1)
                gens.add(gens.get(gens.size() - 2).add(gens.get(gens.size() - 1)).subtract(BigInteger.ONE));//F(n-2)+F(n-1)-1
            else
                gens.add(gens.get(gens.size() - 2).add(gens.get(gens.size() - 1)).subtract(gens.get(gens.size() - m - 1))); //F(n-2)+F(n-1)-F(n-j-1)
        }
        return gens.get(gens.size() - 1);
    }
}
