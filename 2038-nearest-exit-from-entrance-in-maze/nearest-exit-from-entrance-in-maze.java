class Solution {

    record Point(int row, int col, int dist) {}
    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {

        int n = maze.length, m = maze[0].length;

        boolean vis[][] = new boolean[n][m];
        vis[entrance[0]][entrance[1]] = true;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(entrance[0], entrance[1], 0));

        while (!q.isEmpty()) {

            Point curr = q.poll();
            int row = curr.row(), col = curr.col();
            int dist = curr.dist();

            System.out.println(row + " " + col + " " + dist);

            if ((row == 0 || row == n-1 || col == 0 || col == m-1) && !(row == entrance[0] && col == entrance[1])) {

                return dist;
            }

            for (int dir[] : dirs) {

                int new_row = row + dir[0], new_col = col + dir[1];

                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && !vis[new_row][new_col] && maze[new_row][new_col] == '.') {

                    vis[new_row][new_col] = true;

                    q.offer(new Point(new_row, new_col, dist + 1));
                }
            }
        }

        return -1;
    }
}