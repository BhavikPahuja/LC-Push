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

    Map<Long, Integer> freq = new HashMap<>();
    int ans = 0;

    void rec(TreeNode curr, long curr_sum, int k) {

        if (curr == null) {

            return;
        }

        curr_sum += curr.val;

        ans += freq.getOrDefault(curr_sum - k, 0);

        freq.put(curr_sum, freq.getOrDefault(curr_sum, 0) + 1);

        rec(curr.left, curr_sum, k);
        rec(curr.right, curr_sum, k);

        freq.put(curr_sum, freq.getOrDefault(curr_sum, 0) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        
        freq.put(0L, 1);

        rec(root, 0L, targetSum);

        return ans;
    }
}