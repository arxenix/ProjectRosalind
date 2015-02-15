package me.ankur.rosalind;

import me.ankur.rosalind.util.Algorithm;
import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.Util;

import java.util.List;

/**
 * Created by Sundara on 1/18/15.
 */
public class LCSM {
    public static void main(String[] args) {
        List<FastaSection> fasta = Util.readFasta("rosalind_lcsm");

        String lastCommon = Algorithm.longestSubstring(fasta.get(0).getSequence().toString(), fasta.get(1).getSequence().toString());
        for (int i = 2; i < fasta.size(); i++) {
            lastCommon = Algorithm.longestSubstring(lastCommon, fasta.get(i).getSequence().toString());
        }

        System.out.println(lastCommon.toUpperCase());
    }
}
