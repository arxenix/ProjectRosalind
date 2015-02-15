package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class DNASequence extends Sequence {
    public DNASequence(String s) {
        super(s);
    }

    public DNASequence(char[] s) {
        super(s);
    }

    public static char complement(char c) {
        if (c == 'A') return 'T';
        if (c == 'T') return 'A';
        if (c == 'C') return 'G';
        if (c == 'G') return 'C';
        return '\0';
    }

    public RNASequence transcribe() {
        return new RNASequence(toString().replaceAll("T", "U"));
    }

    public DNASequence complement() {
        return new DNASequence(
                toString()
                        .replaceAll("A", "X")
                        .replaceAll("T", "A")
                        .replaceAll("X", "T")
                        .replaceAll("G", "X")
                        .replaceAll("C", "G")
                        .replaceAll("X", "C"));
    }

    public DNASequence reverseComplement() {
        DNASequence ret = complement();
        ret.reverse();
        return ret;
    }

    public double transitionTransversionsRatio(DNASequence d2) {
        double transitions = 0; //purines (A-G)
        double transversions = 0; //purines (C-T)
        for (int i = 0; i < getSequence().length; i++) {
            char a = getSequence()[i];
            char b = d2.getSequence()[i];
            if (a != b) {
                if ((a == 'A' || a == 'G') && (b == 'A' || b == 'G'))
                    transitions++;
                else if ((a == 'C' || a == 'T') && (b == 'C' || b == 'T'))
                    transitions++;
                else
                    transversions++;
            }
        }
        return transitions / transversions;
    }
}
