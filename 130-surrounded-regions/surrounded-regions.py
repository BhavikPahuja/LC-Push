class Solution:
    def dfs(self, i: int, j: int, vis: List[List[bool]], board: List[List[str]]) -> None:
        m, n = len(board), len(board[0])
        vis[i][j] = 0
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for di, dj in dirs:
            r, c = i + di, j + dj
            if (0 <= r < m and 0 <= c < n and board[r][c] == 'O' and vis[r][c] == -1):
                self.dfs(r, c, vis, board)
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        vis = [[-1 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            if board[i][0] == 'O':
                self.dfs(i, 0, vis, board)
        for j in range(n):
            if board[0][j] == 'O':
                self.dfs(0, j, vis, board)
        for i in range(m):
            if board[i][n - 1] == 'O':
                self.dfs(i, n - 1, vis, board)
        for j in range(n):
            if board[m - 1][j] == 'O':
                self.dfs(m - 1, j, vis, board)
        for i in range(m):
            for j in range(n):
                if vis[i][j] == -1 and board[i][j] == 'O':
                    board[i][j] = 'X'