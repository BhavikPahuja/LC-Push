class Solution {

    record State(int row, int col, int health) {}

    int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        health -= grid.get(0).get(0);
        if (health <= 0) {

            return false;
        }
        
        int n = grid.size(), m = grid.get(0).size();

        int best[][] = new int[n][m];
        for (int i=0; i<n; i++) {

            Arrays.fill(best[i], -1);
        }

        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, health));
        best[0][0] = health;

        while (!q.isEmpty()) {

            State curr = q.poll();
            int row = curr.row(), col = curr.col(), curr_health = curr.health();

            if (row == n - 1 && col == m - 1) {

                return true;
            }

            for (int dir[] : dirs) {

                int new_row = row + dir[0], new_col = col + dir[1];

                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m) {

                    int new_health = curr_health - grid.get(new_row).get(new_col);
                    if (new_health > 0 && new_health > best[new_row][new_col]) {

                        best[new_row][new_col] = new_health;
                        q.offer(new State(new_row, new_col, new_health));
                    }
                }
            }
        }

        return false;
    }
}