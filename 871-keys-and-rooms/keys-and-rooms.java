class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        boolean vis[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();
            vis[curr] = true;

            for (int nei : rooms.get(curr)) {

                if (vis[nei] == false) {

                    q.offer(nei);
                }
            }
        }

        for (boolean i : vis) {

            if (i == false) {

                return false;
            }
        }

        return true;
    }
}