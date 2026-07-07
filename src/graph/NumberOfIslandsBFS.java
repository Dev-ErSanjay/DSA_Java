package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

    public static int numberOfIslandsBFS(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { i, j });

                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {

                        int[] cell = queue.poll();

                        int row = cell[0];
                        int col = cell[1];

                        for (int[] dir : directions) {

                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if (newRow >= 0 && newRow < grid.length && newCol >= 0 & newCol < grid[0].length
                                    && grid[newRow][newCol] == '1') {
                                queue.offer(new int[] { newRow, newCol });
                                grid[newRow][newCol] = '0';
                            }
                        }

                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println(numberOfIslandsBFS(grid));
    }
}
