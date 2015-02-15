package me.ankur.rosalind.util;

/**
 * Created by Sundara on 1/18/15.
 */
public class Algorithm {

    public static long factorial(int n) {
        if (n == 0) return 1;
        if (n < 2) return n;
        else return factorial(n - 1);
    }

    public static long fac(int n) {
        long ans = n;
        for (int i = n - 1; i > 1; i--) {
            ans *= i;
        }
        return ans;
    }

    public static String longestSubstring(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
            return "";

// java initializes them already with 0
        int[][] num = new int[str1.length()][str2.length()];
        int maxlen = 0;
        int lastSubsBegin = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if ((i == 0) || (j == 0))
                        num[i][j] = 1;
                    else
                        num[i][j] = 1 + num[i - 1][j - 1];

                    if (num[i][j] > maxlen) {
                        maxlen = num[i][j];
                        // generate substring from str1 => i
                        int thisSubsBegin = i - num[i][j] + 1;
                        if (lastSubsBegin == thisSubsBegin) {
                            //if the current LCS is the same as the last time this block ran
                            sb.append(str1.charAt(i));
                        } else {
                            //this block resets the string builder if a different LCS is found
                            lastSubsBegin = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(str1.substring(lastSubsBegin, i + 1));
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

    public static String commonSubstring(String... strings) {
        String common = "";
        String smallest = "";

        //identify smallest String
        for (String s : strings) {
            if (smallest.length() < s.length()) {
                smallest = s;
            }
        }

        StringBuilder tempCom = new StringBuilder();
        char[] smallStrChars = smallest.toCharArray();
        for (char c : smallStrChars) {
            tempCom.append(c);

            for (String s : strings) {
                if (!s.contains(tempCom)) {
                    tempCom.setLength(0);
                    break;
                }
            }
            if (tempCom.length() > common.length())
                common = tempCom.toString();
        }
        return common;
    }
}
