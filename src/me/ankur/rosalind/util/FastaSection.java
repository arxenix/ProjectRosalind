package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class FastaSection {
    private String label;
    private GeneticSequence sequence;

    public FastaSection(String label, GeneticSequence sequence) {
        this.label = label;
        this.sequence = sequence;
    }

    public String getLabel() {
        return label;
    }

    public GeneticSequence getSequence() {
        return sequence;
    }
}
