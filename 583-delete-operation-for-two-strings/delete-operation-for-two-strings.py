class Solution:
    def lcs(self, i: int, j: int, s1: str, s2:str, dp: List[List[int]]) -> int:
        # pruning
        if i >= len(s1) or j >= len(s2):
            return 0
        # base case

        # cache check
        if dp[i][j] != -1:
            return dp[i][j]
        # compute
        ans = float('-inf')
        if s1[i] == s2[j]:
            ans = max(ans, 1 + self.lcs(i + 1, j + 1, s1, s2, dp))
        else:
            ans = max(ans, self.lcs(i + 1, j, s1, s2, dp))
            ans = max(ans, self.lcs(i, j + 1, s1, s2, dp))
        # save and return
        dp[i][j] = ans
        return ans

    def minDistance(self, s1: str, s2: str) -> int:
        n = len(s1)
        m = len(s2)
        dp = [[-1 for _ in range(m)] for _ in range(n)]
        return n + m - 2 * self.lcs(0, 0, s1, s2, dp)