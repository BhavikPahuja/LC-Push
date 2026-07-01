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

    int height(TreeNode node) {

        if (node == null) {

            return 0;
        }

        int left_height = height(node.left);
        int right_height = height(node.right);

        System.out.println("Node: " + node.val + ", " + "Left: " + left_height + ", " + "Right: " + right_height);
        ans = Math.max(ans, left_height + right_height);

        return 1 + Math.max(left_height, right_height);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        height(root);

        return ans;
    }
}