package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class FastaSection {
    private String label;
    private Sequence sequence;

    public FastaSection(String label, Sequence sequence) {
        this.label = label;
        this.sequence = sequence;
    }

    public String getLabel() {
        return label;
    }

    public Sequence getSequence() {
        return sequence;
    }
}
