package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class Protein extends Sequence {
    public Protein(String s) {
        super(s);
    }

    public Protein(char[] s) {
        super(s);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (char c : getSequence()) {
            totalWeight += AminoAcid.valueOf(Character.toString(c)).getWeight();
        }
        return totalWeight;
    }
}
