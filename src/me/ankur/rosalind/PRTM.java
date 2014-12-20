package me.ankur.rosalind;

import me.ankur.rosalind.util.Protein;
import me.ankur.rosalind.util.Util;

/**
 * Created by Sundara on 12/19/14.
 */
public class PRTM {

    public static void main(String[] args) {
        /*String p = Util.readStringFile("rosalind_prtm");

        double totalWeight = 0;
        for(char c:p.toCharArray()) {
            totalWeight+=AminoAcid.valueOf(Character.toString(c)).getWeight();
        }*/
        System.out.println(new Protein(Util.readStringFile("rosalind_prtm")).getWeight());
    }
}
