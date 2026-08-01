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

    int max = - (int) 1e9;

    int rec(TreeNode curr) {

        if (curr == null) {

            return 0;
        }

        int left_sum = Math.max(0, rec(curr.left));
        int right_sum = Math.max(0, rec(curr.right));

        max = Math.max(max, left_sum + right_sum + curr.val);

        return curr.val + Math.max(left_sum, right_sum);
    }

    public int maxPathSum(TreeNode root) {
        
        rec(root);

        return max;
    }
}