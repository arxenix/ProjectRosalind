package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class GeneticSequence {
    private char[] sequence;

    public GeneticSequence(String s) {
        sequence = s.toCharArray();
    }

    public char[] getSequence() {
        return sequence;
    }
}
