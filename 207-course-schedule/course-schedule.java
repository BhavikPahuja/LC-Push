class Solution {

    int cnt = 0;

    void dfs(int node, List<List<Integer>> adj, Stack<Integer> st, int indegree[]) {
        cnt++;
        indegree[node]--;
        for (int nei : adj.get(node)) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                dfs(nei, adj, st, indegree);
            }
        }
        st.push(node);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for (int prerequist[] : prerequisites) {
            int u = prerequist[0], v = prerequist[1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Stack<Integer> st = new Stack<>();

        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                dfs(i, adj, st, indegree);
            }
        }

        System.out.println(cnt);

        return cnt == numCourses;
    }
}