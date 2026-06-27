class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        int ans = (map.getOrDefault(1, 0) - 1) | 1;
        map.remove(1);
        for (int key : map.keySet()) {
            int curr = 0;
            int x = key;
            while (map.getOrDefault(x, 0) > 1) {
                curr += 2;
                x *= x;
            }
            ans = Math.max(ans, curr + (map.containsKey(x) ? 1 : -1));
        }
        return ans;
    }
}