package me.ankur.rosalind.util;

/**
 * Created by Sundara on 1/22/15.
 */
public class SequenceMotif {

    /*private List<Section> sections = new ArrayList<Section>();

    public SequenceMotif(String seq) {
        Section s=null;
        StringBuilder sb = new StringBuilder();
        for(char c:seq.toCharArray()) {
            if(c=='{') {
                s=new Section();
                s.or=true;
            }
            else if(c=='[') {
                s=new Section();
                s.not=true;
            }
            else if(c=='}') {
                if(s!=null) {
                    s.string=sb.toString();
                    sections.add(s);
                    sb.setLength(0);
                    s.or=false;
                }
            }
            else if(c==']') {
                if(s!=null) {
                    s.string=sb.toString();
                    sections.add(s);
                    sb.setLength(0);
                    s.not=false;
                }
            }
            else if (s != null && !s.not && !s.or) {
                sb.append(c);
            }
            else {
                s = new Section();
                s.string = Character.toString(c);
                sections.add(s);
                s=null;
            }
        }
    }

    public boolean findMotif(Sequence seq) {
        for(char c:seq.getSequence()) {

            for(Section )

        }
    }

    class Section {
        String string;
        boolean not;
        boolean or;

        public boolean matches(char c) {
            if(not) {
                return string.contains(Character.toString(c));
            }
            else if(or) {

            }
            else {

            }
        }
    }*/
}
