package me.ankur.rosalind;

import me.ankur.rosalind.util.DNASequence;
import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.Util;

import java.util.List;

/**
 * Created by Sundara on 12/19/14.
 */
public class SPLC {

    public static void main(String[] args) {
        List<FastaSection> fasta = Util.readFasta("rosalind_splc");
        String seq = fasta.get(0).getSequence().toString();
        fasta.remove(0);

        for (FastaSection f : fasta) {
            seq = seq.replaceAll(f.getSequence().toString(), "");
        }

        System.out.println(new DNASequence(seq).transcribe().translate());
    }
}
