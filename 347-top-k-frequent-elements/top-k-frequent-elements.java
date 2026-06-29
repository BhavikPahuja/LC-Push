class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        int n = nums.length;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int key : freq.keySet()) {
            buckets.get(freq.get(key)).add(key);
        }

        int ans[] = new int[k];
        int x = 0;

        for (int i=n; i>=0; i--) {
            if (buckets.get(i).size() > 0) {
                for (int num : buckets.get(i)) {
                    ans[x++] = num;
                    if (x == k) {
                        return ans;
                    }
                }
            }
        }

        return new int[]{-1};
    }
}