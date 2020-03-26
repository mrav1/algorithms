package set2;

import java.util.Arrays;

public class CutThroughCharsEqually {

    public static void main(String[] args) {
        System.out.println(splitChars("aaacc"));
    }

    private static String splitChars(String var) {
        int[] charLen = getCharLen(var);
        if (charLen == null) return null;

        Arrays.sort(charLen);
        int i = 0;
        while (charLen[i] == 0)
            i++;
        int min = charLen[i];
        int max = charLen[charLen.length - 1];

        if (max - min == 0 && charLen.length - 1 - i == 1) return "YES"; // aabb

        if (max - min == 1 && charLen.length - 1 - i == 1) return "YES"; // aaabb

        if (min == 1 && charLen[i + 1] == max) return "YES"; //aabcc

        return "NO";
    }

    private static int[] getCharLen(String var) {
        if (var == null || var.isEmpty()) return null;
        int[] vars = new int[26];
        for (char c : var.toCharArray()) {
            int index = c - 'a';
            vars[index]++;
        }
        return vars;
    }


}
