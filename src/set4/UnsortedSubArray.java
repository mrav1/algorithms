package set4;

public class UnsortedSubArray {

    public static void main(String[] args) {
        System.out.println(unsorted(new int[]{2, 3, 5, 4, 7, 6, 1}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find first min element after a max (left -> right)
        for (int i = 1; i < nums.length; i++) { //[2 3 5 4 7 6, 1], min = 4
            if (nums[i] < nums[i - 1])
                min = Math.min(min, nums[i]);
        }

        // Find first max element after a min (right -> left)
        for (int i = nums.length - 2; i >= 0; i--) { // [2 3 5 4 7 6, 1], max=6
            if (nums[i] > nums[i + 1])
                max = Math.max(max, nums[i]);
        }

        int l, r;
        // start index of unsorted array
        for (l = 0; l < nums.length; l++) { // [2 3 5 4 7 6, 1], l=2 ie at 5
            if (min < nums[l])
                break;
        }

        // end index of unsorted array
        for (r = nums.length - 1; r >= 0; r--) { // [2 3 5 4 7 6, 1], r=6 ie at 1
            if (max > nums[r])
                break;
        }

        return r - l < 0 ? 0 : r - l + 1; // 6-2+1=5 ie., [5 4 7 6 1]
    }

    static int unsorted(int[] nums) { // [2 3 5 4 7 6, 1]
        int i = 0;
        int j = nums.length - 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int s = 0;
        int e = -1;

        while (j >= 0) { //[2 3 5 4 7 6, 1]

            if (nums[i] >= max) {
                max = nums[i];
            } else {
                e = i;
            }

            if (nums[j] <= min) {
                min = nums[j];
            } else {
                s = j;
            }

            i++;
            j--;
        }

        return e - s + 1;

    }

}
