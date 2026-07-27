class Solution {

    void rec(int level, int a[], List<Integer> curr, List<List<Integer>> ans) {

        if (level == a.length) {

            ans.add(new ArrayList<>(curr));
            return;
        }

        rec(level + 1, a, curr, ans);
        curr.add(a[level]);
        rec(level + 1, a, curr, ans);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        rec(0, nums, new ArrayList<Integer>(), ans);

        return ans;
    }
}