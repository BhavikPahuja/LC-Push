class Solution:
    def rec(self, level: int, s: str, dp: List[int]) -> int:
        # base case
        if level == len(s):
            return 1
        # pruning
        if s[level] == '0':
            return 0
        # cache check
        if dp[level] != -1:
            return dp[level]
        # compute
        ans = 0
        ans += self.rec(level + 1, s, dp)
        if level < len(s) - 1 and int(s[level : level + 2]) <= 26:
            ans += self.rec(level + 2, s, dp)
        # save and return
        dp[level] = ans
        return ans
    def numDecodings(self, s: str) -> int:
        dp = [-1] * len(s)
        return self.rec(0, s, dp)