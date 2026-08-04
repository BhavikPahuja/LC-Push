class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {

            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean vis[] = new boolean[n];
        vis[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while (!q.isEmpty()) {

            int curr = q.poll();

            if (curr == destination) {

                return true;
            }

            for (int nei : adj.get(curr)) {

                if (!vis[nei]) {

                    q.offer(nei);
                    vis[nei] = true;
                }
            }
        }

        return false;
    }
}