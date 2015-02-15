package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class Sequence {
    private char[] sequence;

    public Sequence(String s) {
        sequence = s.toCharArray();
    }

    public Sequence(char[] s) {
        sequence = s;
    }

    public char[] getSequence() {
        return sequence;
    }

    public void reverse() {
        for (int i = 0; i < sequence.length / 2; i++) {
            char temp = sequence[i];
            sequence[i] = sequence[sequence.length - 1 - i];
            sequence[sequence.length - 1 - i] = temp;
        }
    }

    public int hammingDistance(Sequence s2) {
        int distance = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != s2.sequence[i])
                distance++;
        }
        return distance;
    }

    public String toString() {
        return new String(sequence);
    }
}
