package me.ankur.rosalind.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sundara on 12/19/14.
 */
public class RNASequence extends Sequence {
    private static final Map<String, Character> codonsMap;

    static {
        codonsMap = new HashMap<String, Character>();
        codonsMap.put("UUU", 'F');
        codonsMap.put("UUC", 'F');
        codonsMap.put("UUA", 'L');
        codonsMap.put("UUG", 'L');

        codonsMap.put("CUU", 'L');
        codonsMap.put("CUC", 'L');
        codonsMap.put("CUA", 'L');
        codonsMap.put("CUG", 'L');

        codonsMap.put("AUU", 'I');
        codonsMap.put("AUC", 'I');
        codonsMap.put("AUA", 'I');
        codonsMap.put("AUG", 'M'); //Start

        codonsMap.put("GUU", 'V');
        codonsMap.put("GUC", 'V');
        codonsMap.put("GUA", 'V');
        codonsMap.put("GUG", 'V');

        codonsMap.put("UCU", 'S');
        codonsMap.put("UCC", 'S');
        codonsMap.put("UCA", 'S');
        codonsMap.put("UCG", 'S');

        codonsMap.put("CCU", 'P');
        codonsMap.put("CCC", 'P');
        codonsMap.put("CCA", 'P');
        codonsMap.put("CCG", 'P');

        codonsMap.put("ACU", 'T');
        codonsMap.put("ACC", 'T');
        codonsMap.put("ACA", 'T');
        codonsMap.put("ACG", 'T');

        codonsMap.put("GCU", 'A');
        codonsMap.put("GCC", 'A');
        codonsMap.put("GCA", 'A');
        codonsMap.put("GCG", 'A');

        codonsMap.put("UAU", 'Y');
        codonsMap.put("UAC", 'Y');
        codonsMap.put("UAA", '-'); //Stop codon - ochre
        codonsMap.put("UAG", '-'); //Stop codon - ambre

        codonsMap.put("CAU", 'H');
        codonsMap.put("CAC", 'H');
        codonsMap.put("CAA", 'Q');
        codonsMap.put("CAG", 'Q');

        codonsMap.put("AAU", 'N');
        codonsMap.put("AAC", 'N');
        codonsMap.put("AAA", 'K');
        codonsMap.put("AAG", 'K');

        codonsMap.put("GAU", 'D');
        codonsMap.put("GAC", 'D');
        codonsMap.put("GAA", 'E');
        codonsMap.put("GAG", 'E');

        codonsMap.put("UGU", 'C');
        codonsMap.put("UGC", 'C');
        codonsMap.put("UGA", 'W');//Stop codon - opal
        codonsMap.put("UGG", 'W');

        codonsMap.put("CGU", 'R');
        codonsMap.put("CGC", 'R');
        codonsMap.put("CGA", 'R');
        codonsMap.put("CGG", 'R');

        codonsMap.put("AGU", 'S');
        codonsMap.put("AGC", 'S');
        codonsMap.put("AGA", 'R');
        codonsMap.put("AGG", 'R');

        codonsMap.put("GGU", 'G');
        codonsMap.put("GGC", 'G');
        codonsMap.put("GGA", 'G');
        codonsMap.put("GGG", 'G');
    }

    public RNASequence(String s) {
        super(s);
    }

    public Protein translate() {
        StringBuilder translate = new StringBuilder();
        String temp = toString();
        String codon;
        for (int i = 0; i < temp.length() - 2; i = i + 3) {
            codon = temp.substring(i, i + 3);
            translate.append(codonsMap.get(codon));
        }
        return new Protein(translate.toString());
    }
}
