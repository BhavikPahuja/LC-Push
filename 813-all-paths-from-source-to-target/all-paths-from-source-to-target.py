class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        n = len(graph)
        vis = [False for _ in range(n)]

        q = []
        q.append(0)
        vis[0] = True

        ans = []
        curr_path = [0]

        def dfs(node: int) -> null:

            if (node == n - 1):
                ans.append(curr_path.copy())
                return

            for nei in graph[node]:

                curr_path.append(nei)
                dfs(nei)
                curr_path.pop()

        dfs(0)

        return ans