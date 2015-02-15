package me.ankur.rosalind;

import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.GenericUtil;
import me.ankur.rosalind.util.Util;

import java.util.List;

/**
 * Created by Sundara on 12/19/14.
 */
public class CONS {
    /*
    Given: A collection of at most 10 DNA strings of equal length (at most 1 kbp) in FASTA format.

    Return: A consensus string and profile matrix for the collection. (If several possible consensus strings exist, then you may return any one of them.)
     */

    public static void main(String[] args) {
        List<FastaSection> sections = Util.readFasta("rosalind_cons");
        int size = sections.get(0).getSequence().getSequence().length;

        int[][] counts = new int[4][size];
        for(FastaSection s:sections) {
            for(int i=0;i<s.getSequence().getSequence().length;i++) {
                char ch = s.getSequence().getSequence()[i];
                switch (ch) {
                    case 'A':
                        counts[0][i]++;
                        break;
                    case 'C':
                        counts[1][i]++;
                        break;
                    case 'G':
                        counts[2][i]++;
                        break;
                    case 'T':
                        counts[3][i]++;
                        break;
                }
            }
        }

        //find consensus string

        StringBuilder cons = new StringBuilder();
        for(int i=0;i<size;i++) {
            int maxid = 0;
            int max = 0;
            for(int j=0;j<4;j++) {
                if(counts[j][i] > max) {
                    maxid = j;
                    max = counts[j][i];
                }
            }

            switch (maxid) {
                case 0:
                    cons.append('A');
                    break;
                case 1:
                    cons.append('C');
                    break;
                case 2:
                    cons.append('G');
                    break;
                case 3:
                    cons.append('T');
                    break;
            }
        }


        System.out.println(cons.toString());
        System.out.println("A: " + GenericUtil.arrayJoin(counts[0], " "));
        System.out.println("C: " + GenericUtil.arrayJoin(counts[1], " "));
        System.out.println("G: " + GenericUtil.arrayJoin(counts[2], " "));
        System.out.println("T: " + GenericUtil.arrayJoin(counts[3], " "));
    }

    public static int getNumericVal(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
