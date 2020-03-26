package set2;

public class MaxProfit {

    public static void main(String[] args) {
        int prices[] = {1, 5, 2, 3, 7, 6, 4, 5};
        int k = 3;
        System.out.println("Max profit: " + maxProfit(prices, k));
    }

    private static int maxProfit(int[] prices, int k) {
        int n = prices.length;

        int[][] profit = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            int prev_diff = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                } else {
                    prev_diff = Math.max(profit[i - 1][j - 1] - prices[j - 1], prev_diff);
                    profit[i][j] = Math.max(profit[i][j - 1], prev_diff + prices[j]);
                }
            }
        }

        return profit[k][n - 1];
    }

}
