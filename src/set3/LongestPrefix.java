package set3;

public class LongestPrefix {

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeksmeeeek", "geeksmeeeek", "geekmeeeek", "geekzermeeeek"};
        String prefix = longestCommonPrefix(arr);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) return "";
        if (arr.length == 1) return arr[0];

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) == -1) {
                if (prefix.length() > 1) {
                    prefix = prefix.substring(0, prefix.length()-1);
                } else {
                    return "";
                }
            }
        }

        return prefix;
    }

}
