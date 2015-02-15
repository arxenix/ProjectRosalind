package me.ankur.rosalind;

import me.ankur.rosalind.util.DNASequence;
import me.ankur.rosalind.util.Util;

/**
 * Created by Sundara on 2/15/15.
 */
public class REVP {

    public static void main(String[] args) {
        String dna = Util.readFasta("rosalind_revp").get(0).getSequence().toString();
        for (int length = 4; length <= 12; length++) {
            for (int i = 0; i < dna.length() - length + 1; i++) {
                String window = dna.substring(i, i + length);
                if (isReversePalindrome(window)) {
                    System.out.println((i + 1) + " " + length);
                }
            }
        }
    }

    public static boolean isReversePalindrome(String dna) {
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != DNASequence.complement(dna.charAt(dna.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
