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

    int rec(TreeNode curr) {

        if (curr.left == null && curr.right == null) {

            return curr.val;
        }

        int left = rec(curr.left);
        int right = rec(curr.right);

        if (curr.val == 2) {

            return left | right;
        } else {

            return left & right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        
        return rec(root) == 0 ? false : true;
    }
}