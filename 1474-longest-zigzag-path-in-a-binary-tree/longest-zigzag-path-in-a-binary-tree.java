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
   
    int ans = 0;
   
    private void dfs(TreeNode node, boolean left, int curr) {
   
        if (node == null) {
   
            return;
        }
   
        ans = Math.max(ans, curr);
   
        if (left) {
   
            dfs(node.left, false, curr + 1);
            dfs(node.right, true, 1);
        } else {
   
            dfs(node.left, false, 1);
            dfs(node.right, true, curr + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
   
        dfs(root, true, 0);
   
        return ans;
    }
}