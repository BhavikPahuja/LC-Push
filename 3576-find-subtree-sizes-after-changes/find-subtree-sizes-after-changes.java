class Solution {

    int calc(int curr, List<List<Integer>> finalAdj, int ans[]) {
        
        int size = 1;
        
        for (int next : finalAdj.get(curr)) {
        
            size += calc(next, finalAdj, ans);
        }
        
        ans[curr] = size;
        return size;
    }

    void dfs(int curr, List<List<Integer>> initAdj, List<List<Integer>> finalAdj, int seen[], String s, int parent[]) {
        
        int ch = s.charAt(curr) - 'a';
        int prev = seen[ch];

        if (curr != 0) {
        
            int k = (prev != -1) ? prev : parent[curr];
            finalAdj.get(k).add(curr);
        }

        seen[ch] = curr;

        for (int child : initAdj.get(curr)) {
        
            dfs(child, initAdj, finalAdj, seen, s, parent);
        }

        seen[ch] = prev;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        
        int n = parent.length;
        
        List<List<Integer>> initAdj = new ArrayList<>();
        List<List<Integer>> finalAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        
            initAdj.add(new ArrayList<>());
            finalAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
        
            initAdj.get(parent[i]).add(i);
        }

        int seen[] = new int[26];
        Arrays.fill(seen, -1);

        dfs(0, initAdj, finalAdj, seen, s, parent);

        int ans[] = new int[n];
        calc(0, finalAdj, ans);
        return ans;
    }
}