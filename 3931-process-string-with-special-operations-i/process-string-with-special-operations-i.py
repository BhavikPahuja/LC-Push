class Solution:
    def processStr(self, s: str) -> str:
        ans = ""
        for c in s:
            if c == '*':
                ans = ans[:-1]
            elif c == '#':
                ans += ans
            elif c == '%':
                ans = ans[::-1]
            else:
                ans +=c
        return ans