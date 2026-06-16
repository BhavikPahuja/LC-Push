class Solution:
    def dfs(self, i: int, j: int, grid: List[List[int]]) -> None:
        m, n = len(grid), len(grid[0])
        grid[i][j] = -1
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for di, dj in dirs:
            r, c = i + di, j + dj
            if (0 <= r < m and 0 <= c < n and grid[r][c] == 1):
                self.dfs(r, c, grid)
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    if grid[i][j] == 1:
                        self.dfs(i, j, grid)
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    ans += 1
        return ans