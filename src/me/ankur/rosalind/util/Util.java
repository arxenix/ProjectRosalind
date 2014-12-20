package me.ankur.rosalind.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sundara on 12/19/14.
 */
public class Util {

    public static List<FastaSection> readFasta(String s) {
        List<FastaSection> sections = new ArrayList<FastaSection>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(Util.class.getResourceAsStream("/resources/" + s + ".txt")));

            String label = null;
            StringBuilder seq = new StringBuilder();
            String line;
            while((line=in.readLine())!=null) {
                if(line.startsWith(">")) {
                    if(label!=null) {
                        sections.add(new FastaSection(label, new GeneticSequence(seq.toString())));
                    }
                    label = line.substring(1);
                    seq = new StringBuilder();
                }
                else {
                    seq.append(line);
                }
            }
            if(label!=null) {
                sections.add(new FastaSection(label, new GeneticSequence(seq.toString())));
            }
            in.close();
        }
        catch (Exception ignored) {}
        return sections;
    }
}
