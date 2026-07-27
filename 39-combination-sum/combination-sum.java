class Solution {

    void rec(int level, int a[], int k, List<Integer> curr, List<List<Integer>> ans) {

        if (k < 0) {

            return;
        }

        if (k == 0) {

            ans.add(new ArrayList<Integer>(curr));
        }

        for (int i=level; i<a.length; i++) {

            curr.add(a[i]);
            rec(i, a, k - a[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();

        rec(0, candidates, target, new ArrayList<>(), ans);
        
        return ans; 
    }
}