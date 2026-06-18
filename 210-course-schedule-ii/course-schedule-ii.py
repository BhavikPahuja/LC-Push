class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = defaultdict(list)
        indegree = [0] * numCourses
        for u, v in prerequisites:
            adj[v].append(u)
            indegree[u] += 1
        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        ans = []
        while q:
            node = q.popleft()
            ans.append(node)
            for cell in adj[node]:
                indegree[cell] -= 1
                if indegree[cell] == 0:
                    q.append(cell)
        return [] if len(ans) < numCourses else ans