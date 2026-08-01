/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode ans = null;

    boolean rec(TreeNode curr, TreeNode p, TreeNode q) {

        if (curr == null) {

            return false;
        }

        boolean left = rec(curr.left, p, q);
        boolean right = rec(curr.right, p, q);
        boolean self = (curr == p) || (curr == q);

        if ((left && right) || (left && self) || (self && right)) {

            ans = curr;
        }

        return left || self || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        rec(root, p, q);

        return ans;
    }
}