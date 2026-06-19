class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        adj = defaultdict(list)
        indegree = [0] * n
        for i in range(n):
            for nei in graph[i]:
                adj[nei].append(i)
                indegree[i] += 1
        q = deque()
        for i in range(n):
            if indegree[i] == 0:
                q.append(i)
        while q:
            node = q.popleft()
            for nei in adj[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)
        safe_nodes = []
        for i in range(n):
            if indegree[i] == 0:
                safe_nodes.append(i)
        return safe_nodes