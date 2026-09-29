class Solution {

    boolean rec(int row, int col, int cnt, char board[][], int dp[][][]) {

        if (cnt < 0) {

            return false;
        }

        int n = board.length, m = board[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m) {

            return false;
        }

        if (board[row][col] == '(') {

            cnt++;
        } else {

            cnt--;
        }

        if (row == n - 1 && col == m - 1) {

            if (cnt == 0) {

                return true;
            } else {

                return false;
            }
        }

        if (dp[row][col][cnt + 100] != -1) {

            return dp[row][col][cnt + 100] == 1;
        }

        boolean ans = false;

        ans = ans || rec(row + 1, col, cnt, board, dp);
        ans = ans || rec(row, col + 1, cnt, board, dp);
    
        dp[row][col][cnt + 100] = ans ? 1 : 0;

        return ans;
    }

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length, m = grid[0].length;

        if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')') {

            return false;
        }

        int dp[][][] = new int[100][100][1000];

        for (int i[][] : dp) {

            for (int j[] : i) {

                Arrays.fill(j, -1);
            }
        }

        return rec(0, 0, 0, grid, dp);
    }
}