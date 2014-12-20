package me.ankur.rosalind;

import me.ankur.rosalind.util.AminoAcid;
import me.ankur.rosalind.util.Util;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Sundara on 12/19/14.
 */
public class MRNA {

    public static void main(String[] args) {
        //init hashmap with # of corresponding possible MRNA codons for each AA
        HashMap<AminoAcid, Integer> p = new HashMap<AminoAcid, Integer>();
        p.put(AminoAcid.F, 2);
        p.put(AminoAcid.L, 6);
        p.put(AminoAcid.I, 3);
        p.put(AminoAcid.M, 1);
        p.put(AminoAcid.V, 4);
        p.put(AminoAcid.S, 6);
        p.put(AminoAcid.P, 4);
        p.put(AminoAcid.T, 4);
        p.put(AminoAcid.A, 4);
        p.put(AminoAcid.Y, 2);
        p.put(AminoAcid.H, 2);
        p.put(AminoAcid.Q, 2);
        p.put(AminoAcid.N, 2);
        p.put(AminoAcid.K, 2);
        p.put(AminoAcid.D, 2);
        p.put(AminoAcid.E, 2);
        p.put(AminoAcid.C, 2);
        p.put(AminoAcid.W, 1);
        p.put(AminoAcid.R, 6);
        p.put(AminoAcid.G, 4);

        BigInteger possibilities = BigInteger.ONE;

        char[] prot = Util.readStringFile("rosalind_mrna").toCharArray();
        for (char aProt : prot) {
            AminoAcid a = AminoAcid.valueOf(Character.toString(aProt));
            int n = p.get(a);
            possibilities = possibilities.multiply(BigInteger.valueOf(n));
            possibilities = possibilities.mod(BigInteger.TEN.pow(6));
            //if not using BigInteger, could use substring to take the last 6 digits of the number to mod 10^6
            //but biginteger reduces the hassle :)
        }

        //# of stop codons
        possibilities = possibilities.multiply(BigInteger.valueOf(3));
        possibilities = possibilities.mod(BigInteger.TEN.pow(6));


        System.out.println(possibilities);
    }
}
