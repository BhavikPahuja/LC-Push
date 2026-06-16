class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        color = [-1 for _ in range(n)]
        for i in range(n):
            if color[i] == -1:
                q = deque([i])
                color[i] = 0
                while q:
                    node = q.popleft()
                    for cell in graph[node]:
                        if color[cell] == -1:
                            color[cell] = 1 - color[node]
                            q.append(cell)
                        elif color[cell] == color[node]:
                            return False
        return True
