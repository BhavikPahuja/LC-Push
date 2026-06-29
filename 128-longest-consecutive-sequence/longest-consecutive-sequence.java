class Solution {
    int longestConsecutive(int nums[]) {
		Map<Integer, Integer> start = new HashMap<>(), end = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int len = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        for (int i=0; i<n; i++) {
            int x = nums[i];
            if (seen.contains(x)) {
                continue;
            }
            seen.add(x);
            int lc = x - 1;
            int rc = x + 1;
            int curr = 1;
            int ll = end.getOrDefault(lc, 0);
            int rl = start.getOrDefault(rc, 0);
            curr += (ll + rl);
            int lb = x - ll;
            int rb = x + rl;
            start.remove(rc);
            end.remove(lc);
            start.put(lb, curr);
            end.put(rb, curr);
            len = Math.max(len, curr);
        }
        return len;
    }
}