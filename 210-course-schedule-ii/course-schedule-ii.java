class Solution {
    boolean dfs(int node, List<List<Integer>> adj, Stack<Integer> st, int vis[]) {
        
        vis[node] = 1;
        
        for (int nei : adj.get(node)) {
            
            if (vis[nei] == 0) {
                if (dfs(nei, adj, st, vis)) {
                    return true;
                }
            } else if (vis[nei] == 1) {
                return true;
            }
        }
        
        vis[node] = 2;
        st.push(node);

        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int prerequisit[] : prerequisites) {
            int u = prerequisit[0], v = prerequisit[1];
            adj.get(v).add(u);
        }
        
        int vis[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        
        for (int i=0; i<numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, st, vis)) {
                    return new int[0];
                }
            }
        }
        
        int ans[] = new int[numCourses];
        int i = 0;
        
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        
        return ans;
    }
}