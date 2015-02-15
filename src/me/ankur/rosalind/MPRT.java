package me.ankur.rosalind;

import me.ankur.rosalind.util.FastaSection;
import me.ankur.rosalind.util.GenericUtil;
import me.ankur.rosalind.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sundara on 2/14/15.
 */
public class MPRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> proteins = new ArrayList<String>();
        int amt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < amt; i++) {
            proteins.add(sc.nextLine());
        }

        for (String p : proteins) {
            FastaSection section = Util.getProteinSequence(p);
            //System.out.println(section.getSequence().toString());
            char[] chars = section.getSequence().getSequence();

            List<Integer> validLocations = new ArrayList<Integer>();
            //TODO finish SequnceMotif class and use that instead
            for (int i = 0; i < chars.length - 3; i++) {
                if (chars[i] == 'N' && chars[i + 1] != 'P' && (chars[i + 2] == 'S' || chars[i + 2] == 'T') && chars[i + 3] != 'P') {
                    validLocations.add(i + 1);
                }
            }
            if (validLocations.size() > 0) {
                System.out.println(p);
                System.out.println(GenericUtil.listJoin(validLocations, " "));
            }
        }
    }
}
