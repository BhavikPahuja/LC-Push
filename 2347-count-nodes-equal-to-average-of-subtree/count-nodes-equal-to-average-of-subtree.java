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

    int answer = 0;

    private int[] rec(TreeNode node) {
        
        if (node == null) {
        
            return new int[]{0, 0};
        }

        int[] left = rec(node.left);
        int[] right = rec(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (node.val == sum / count) {
        
            answer++;
        }

        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        
        rec(root);
        return answer;
    }
}