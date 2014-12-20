package me.ankur.rosalind.util;

/**
 * Created by Sundara on 12/19/14.
 */
public class GenericUtil {

    public static String arrayJoin(Object[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (Object o : arr) {
            sb.append(o.toString());
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }

    public static String arrayJoin(int[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }

    public static String arrayJoin(char[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }
}
