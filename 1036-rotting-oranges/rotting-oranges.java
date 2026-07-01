class Solution {

    record Point(int row, int col, int time) {}

    public int orangesRotting(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;

        Queue<Point> q = new LinkedList<>();

        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Point(i, j, 0));
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int row = curr.row(), col = curr.col(), time = curr.time();

            ans = Math.max(ans, time);

            int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int dir[] : dirs) {
                int new_row = row + dir[0], new_col = col + dir[1];

                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && grid[new_row][new_col] == 1) {
                    cnt--;
                    grid[new_row][new_col] = 2;
                    q.offer(new Point(new_row, new_col, time + 1));
                }
            }
        }

        return cnt == 0 ? ans : -1;
    }
}