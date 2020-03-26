package set4;

import java.util.Arrays;

public class MoveZerosToRight {
    public static void main(String[] args) {
        int[] s = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes(s);
        System.out.println(Arrays.toString(s));
    }

    public static void moveZeroes(int[] nums) {
        long l = System.nanoTime();

        int i=0;
        int j=1;
        while(i<nums.length && j<nums.length){

            if(nums[i]==0 && nums[j]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

            if(nums[j]==0 || i<j){
                j++;
            }

            if(nums[i]!=0){
                i++;
            }

        }
        System.out.println(System.nanoTime() - l);
//3542
    }

    public static void moveZeroes2(int[] nums) {
        long l = System.nanoTime();
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=0)
                nums[i++] = nums[j];
        }

        while (i<nums.length)
            nums[i++] = 0;
//2895
        System.out.println(System.nanoTime() - l);
    }
}
