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

    private int rec(TreeNode curr) {
        
        if (curr == null) {
            
            return 0;
        }

        int left = rec(curr.left);
        int right = rec(curr.right);

        ans += Math.abs(left) + Math.abs(right);

        return curr.val + left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        rec(root);

        return ans;
    }

}