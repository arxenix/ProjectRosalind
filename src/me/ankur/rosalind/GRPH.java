package me.ankur.rosalind;

import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.Util;

import java.util.List;

/**
 * Created by Sundara on 12/20/14.
 */
public class GRPH {

    public static void main(String[] args) {
        List<FastaSection> fasta = Util.readFasta("rosalind_grph");

        for (int i = 0; i < fasta.size(); i++) {
            for (int j = 0; j < fasta.size(); j++) {
                if (i == j) continue;
                FastaSection fi = fasta.get(i);
                String tail = fi.getSequence().toString();
                FastaSection fj = fasta.get(j);
                String head = fj.getSequence().toString();

                //if end links with beginning
                if (tail.substring(tail.length() - 3).equals(head.substring(0, 3))) {
                    System.out.println(fi.getLabel() + " " + fj.getLabel());
                }
            }
        }
    }
}
