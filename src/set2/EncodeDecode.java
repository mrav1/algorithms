package set2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        String var = "GO VMWare";
        String var_en = encode(var);
        System.out.println(var_en);
        decode(var_en);
        //System.out.println();
    }

    private static List<String> decode(String var_en) {
        StringBuffer buf = new StringBuffer(var_en);
        buf = buf.reverse();

        System.out.println(buf.toString());
        String currentSolution = "";
        String unprocessed = buf.toString();
        unprocessed = unprocessed.replaceAll("-", "");
        List<String> solutions = new ArrayList<>();
        _decode(solutions, currentSolution, unprocessed);

        System.out.println(solutions);

        return solutions;
    }

    static boolean isValid(String var) {
        if (var.startsWith("0"))
            return false;
        int value = Integer.parseInt(var.replace("-", ""));
        if (value < 10 || value > 126)
            return false;

        System.out.println((char) Integer.parseInt(var) + "=" + var);
        return true;
    }


    private static void _decode(List<String> solutions, String currentSolution, String unprocessed) {


        if (unprocessed.length() == 0) {
            solutions.add(currentSolution);
            return;
        } else {
            List<String> possible_splits = new ArrayList<>();
            if (unprocessed.length() >= 2)
                possible_splits.add(unprocessed.substring(0, 2));
            else if (unprocessed.length() >= 3)
                possible_splits.add(unprocessed.substring(0, 3));
            else
                possible_splits.add(unprocessed);

            for (String split : possible_splits) {
                if (isValid(split)) {
                    char decoded_character = (char) Integer.parseInt(split.replace("-", ""));
                    currentSolution += decoded_character;
                    if (unprocessed.length() > split.length())
                        unprocessed = unprocessed.substring(split.length());
                    else
                        System.out.println("pending:;"+unprocessed);
                    _decode(solutions, currentSolution, unprocessed);
                } else {
                    System.out.println("invalid:::-"+split);
                }
            }
        }

    }

    private static String encode(String var) {
        StringBuffer sb = new StringBuffer();
        for (char c : var.toCharArray()) {
            sb.append((int) c);
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static class SubArraySum {
        public static void main(String[] args) {
            System.out.println(subarraySum(new int[]{1, 2, 1}, 3));
        }

        public static int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int count = 0;
            int sum = 0;

            //e.g., 1 2 1
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int n = map.getOrDefault(sum - k, 0);
                count += n;

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }
    }
}
