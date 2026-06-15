from collections import deque

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        ans = 0
        n = len(isConnected)
        q = deque()
        vis = [False for _ in range(n)]
        q.append(0)
        for i in range(n):
            if vis[i] == False:
                q.append(i)
                while q:
                    curr = q.popleft()
                    for j in range(n):
                        if isConnected[curr][j] == 1 and vis[j] == False:
                            q.append(j)
                            vis[j] = True
                ans += 1
        return ans