package me.ankur.rosalind;

import me.ankur.rosalind.util.DNASequence;
import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.Util;

import java.util.List;

/**
 * Created by Sundara on 12/19/14.
 */
public class TRAN {

    public static void main(String[] args) {
        List<FastaSection> fasta = Util.readFasta("rosalind_tran");

        DNASequence d1 = new DNASequence(fasta.get(0).getSequence().getSequence());

        DNASequence d2 = new DNASequence(fasta.get(1).getSequence().getSequence());


        System.out.println(d1.transitionTransversionsRatio(d2));
    }
}
