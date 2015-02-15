package me.ankur.rosalind;

import me.ankur.rosalind.util.DNASequence;
import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.Util;

import java.util.*;

/**
 * Created by Sundara on 2/14/15.
 */
public class ORF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FastaSection fasta = Util.readFasta("rosalind_orf").get(0);
        sc.close();


        DNASequence seq = new DNASequence(fasta.getSequence().toString());
        //seq.reverse();
        //seq.complement();
        List<String> seqs = new ArrayList<String>();

        String reg = seq.toString();
        seqs.add(seq.transcribe().translate().toString());
        seqs.add(new DNASequence(reg.substring(1)).transcribe().translate().toString());
        seqs.add(new DNASequence(reg.substring(2)).transcribe().translate().toString());
        seq = seq.reverseComplement();

        String revc = seq.toString();
        seqs.add(seq.transcribe().translate().toString());
        seqs.add(new DNASequence(revc.substring(1)).transcribe().translate().toString());
        seqs.add(new DNASequence(revc.substring(2)).transcribe().translate().toString());


        Set<String> validProteins = new HashSet<String>();
        for (String s : seqs) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'M') {
                    StringBuilder sb = new StringBuilder();
                    sb.append('M');
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) != '-') {
                            sb.append(s.charAt(j));
                        } else {
                            validProteins.add(sb.toString());
                            break;
                        }
                    }
                }
            }
        }
        for (String prot : validProteins) {
            System.out.println(prot);
        }
    }
}
