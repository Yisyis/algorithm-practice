package com.yis.special.queue.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  200 岛屿数量
 * @author YeShuai
 * @date 2021/1/22
 */
public class NumIslands {

    public int BFS(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return -1;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if ('1' == grid[r][c]) {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbor = new LinkedList<>();
                    neighbor.add(r * nc + c);
                    while(!neighbor.isEmpty()) {
                        int poll = neighbor.poll();
                        int row = poll / nc;
                        int col = poll % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbor.offer((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbor.offer((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbor.offer(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbor.offer(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

}
