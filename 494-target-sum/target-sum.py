class Solution:
    def rec(self, level: int, curr: int, sum: int, k: int, a: List[int], dp: List[List[int]]) -> int:
        # pruning

        # base case
        if level == len(a):
            if 2 * curr - sum == k:
                return 1
            return 0
        # cache check
        if dp[level][curr] != -1:
            return dp[level][curr]
        # compute
        ans = 0
        ans += self.rec(level + 1, curr, sum, k, a, dp)
        ans += self.rec(level + 1, curr + a[level], sum, k, a, dp)
        # save and return
        dp[level][curr] = ans
        return ans

    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)
        n = len(nums)
        dp = [[-1] * (total + 1) for _ in range(n + 1)]
        return self.rec(0, 0, total, target, nums, dp)