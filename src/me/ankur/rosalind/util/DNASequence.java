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
}
