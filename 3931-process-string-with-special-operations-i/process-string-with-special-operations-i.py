class Solution:
    def processStr(self, s: str) -> str:
        res = []
        for c in s:
            if 'a' <= c <= 'z':
                res.append(c)
            elif c == '#':
                res *= 2
            elif c == '%':
                res.reverse()
            elif c == '*' and len(res) > 0:
                res.pop()
        return ''.join(res)