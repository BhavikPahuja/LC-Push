class DisjointSet {
    private int size[];
    private int parent[];

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];

        for (int i=0; i<=n; i++) {
            size[i] = 0;
            parent[i] = i;
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
            size[parent_v] = size[parent_u] + size[parent_v];
        } else {
            parent[parent_v] = parent_u;
            size[parent_u] = size[parent_u] + size[parent_v];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mapMail = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMail.containsKey(mail)) {
                    mapMail.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMail.get(mail));
                }
            }
        }
        
        List<String> mergedMail[] = new ArrayList[n];
        for (int i=0; i<n; i++) {
            mergedMail[i] = new ArrayList<String>();
        }
        
        for (Map.Entry<String, Integer> mails : mapMail.entrySet()) {
            String mail = mails.getKey();
            int node = ds.findParent(mails.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (mergedMail[i].size() == 0) {
                continue;
            }
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }
            ans.add(temp);
        }
        return ans;
    }
}