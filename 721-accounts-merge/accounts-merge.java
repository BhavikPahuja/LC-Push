class DisjointSet {

    int parent[];
    int size[];

    public DisjointSet(int n) {

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i=0; i<n; i++) {

            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {

        if (parent[node] == node) {
            
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {

        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {
            
            return;
        }

        if (size[parent_u] < size[parent_v]) {
            
            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        } else {

            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> mailMap = new HashMap<>();

        for (int i=0; i<n; i++) {
            
            for (int j=1; j<accounts.get(i).size(); j++) {
                
                String mail = accounts.get(i).get(j);
                if (mailMap.containsKey(mail)) {
                    
                    ds.unionBySize(i, mailMap.get(mail));
                } else {
                    
                    mailMap.put(mail, i);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();
        for (int i=0; i<n; i++) {
            
            temp.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : mailMap.entrySet()) {

            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            temp.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {

            if (temp.get(i).size() != 0) {

                Collections.sort(temp.get(i));

                List<String> group = new ArrayList<>();
                group.add(accounts.get(i).get(0));
                group.addAll(temp.get(i));

                ans.add(group);
            }
        }

        return ans;
    }
}