package set4;

import java.util.LinkedList;
import java.util.Queue;

public class TimeToUpdate {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(minDays(grid));
    }

    private static int minDays(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Collect all updated servers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    queue.offer(new int[]{i, j});
                }
            }
        }


        int target = rows * cols; // max count
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int days = 0;

        while (!queue.isEmpty()) {

            // All servers updated when count == target
            if (count == target) {
                return days;
            }

            for (int i = 0; i < queue.size(); i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int ri = cur[0] + dir[0];
                    int ci = cur[1] + dir[1];
                    if (ri >= 0 && ri < rows && ci >= 0 && ci < cols && grid[ri][ci] == 0) {
                        count++;
                        grid[ri][ci] = 1;
                        queue.offer(new int[]{ri, ci});
                    }
                }
            }

            days++;
        }
        return -1;
    }
}
