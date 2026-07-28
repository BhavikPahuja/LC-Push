/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    String dfs(TreeNode curr, Map<String, List<Integer>> mpp, List<TreeNode> ans) {

        if (curr == null) {

            return "#";
        }

        String s = Integer.toString(curr.val) + "," + dfs(curr.left, mpp, ans) + "," + dfs(curr.right, mpp, ans);

        if (mpp.containsKey(s)) {

            if (mpp.get(s).size() == 1) {

                ans.add(curr);
            }

            mpp.get(s).add(1);
        } else {

            mpp.put(s, new ArrayList<>(List.of(1)));
        }

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        Map<String, List<Integer>> mpp = new HashMap<>();

        List<TreeNode> ans = new ArrayList<>();
        dfs(root, mpp, ans);

        return ans;
    }
}