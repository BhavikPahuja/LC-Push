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
    
    int ans = -1;
    int cnt = 0;

    void rec(TreeNode curr, int k) {

        if (curr == null) {

            return;
        }

        if (cnt >= k) {

            return;
        }

        rec(curr.left, k);
        cnt++;
        if (cnt == k) {

            ans = curr.val;
        }
        rec(curr.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        
        rec(root, k);

        return ans;
    }
}