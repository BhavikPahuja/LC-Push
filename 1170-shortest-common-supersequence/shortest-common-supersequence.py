class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        dp = {}
        def lcs(i: int, j: int) -> int:
            # pruning

            # base case
            if i == len(s1) or j == len(s2):
                return ''
            # cache check
            if (i, j) in dp:
                return dp[(i, j)]
            # compute
            if s1[i] == s2[j]:
                dp[(i, j)] = s1[i] + lcs(i + 1, j + 1)
            else:
                left = lcs(i + 1, j)
                right = lcs(i, j + 1)
                if len(left) >= len(right):
                    dp[(i, j)] = left
                else:
                    dp[(i, j)] = right
            # save and return
            return dp[(i, j)]
        s = lcs(0, 0)
        if len(s) == 0:
            return s1 + s2
        i, j = 0, 0
        x = 0
        ans = ''
        while i < len(s1) and j < len(s2):
            while i < len(s1) and s1[i] != s[x]:
                ans += s1[i]
                i += 1
            while j < len(s2) and s2[j] != s[x]:
                ans += s2[j]
                j += 1
            ans += s[x]
            x += 1
            i += 1
            j += 1
            if x == len(s):
                ans += s1[i:]
                ans += s2[j:]
                break
        return ans
