package set3;

public class MaxContiguosSum {

    public static void main(String[] args) {
        int arr[] = {-2, -3, -1, 3, -2, 7, -4, -3};
        int maxSum = maxSum(arr, arr.length);
        System.out.println(maxSum);
    }

    private static int maxSum(int[] arr, int n) {
        int maxSoFar = arr[0];
        int curMax = arr[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }

}
