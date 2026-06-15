from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n, m = len(grid), len(grid[0])
        ans = 0
        vis = [[False for _ in range(m)] for _ in range (n)]
        q = deque()
        for i in range(n):
            for j in range(m):
                if vis[i][j] == False and grid[i][j] == '1':
                    q.append((i, j))
                    vis[i][j] = True
                    while q:
                        curr = q.popleft()
                        r, c = curr[0], curr[1]
                        if r > 0 and vis[r - 1][c] == False and grid[r - 1][c] == '1':
                            vis[r - 1][c] = True
                            q.append((r - 1, c))
                        if r < n - 1 and vis[r + 1][c] == False and grid[r + 1][c] == '1':
                            vis[r + 1][c] = True
                            q.append((r + 1, c))
                        if c > 0 and vis[r][c - 1] == False and grid[r][c - 1] == '1':
                            vis[r][c - 1] = True
                            q.append((r, c - 1))
                        if c < m - 1 and vis[r][c + 1] == False and grid[r][c + 1] == '1':
                            vis[r][c + 1] = True
                            q.append((r, c + 1))
                    ans += 1
        return ans