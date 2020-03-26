package set4;

import java.util.Arrays;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] s = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(s));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (k <= 0) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }

        return res;

    }
}
