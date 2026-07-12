class Solution {
    boolean bfs(int i, List<List<Integer>> adj, boolean seen[]) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        seen[i] = true;

        int v = 0, e = 0;

        while (!q.isEmpty()) {
        
            int u = q.poll();
            v++;
            e += adj.get(u).size();

            for (int n : adj.get(u)) {
        
                if (!seen[n]) {
        
                    seen[n] = true;
                    q.add(n);
                }
            }
        }

        return e == v * (v - 1);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
        
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
        
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int cnt = 0;

        boolean seen[] = new boolean[n];

        for (int i = 0; i < n; i++) {
        
            if (!seen[i]) {
        
                if (bfs(i, adj, seen)) {
        
                    cnt++;
                }
            }
        }

        return cnt;
    }
}