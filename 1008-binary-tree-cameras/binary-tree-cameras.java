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

    Map<TreeNode, TreeNode> mpp = new HashMap<>();
    Set<TreeNode> seen = new HashSet<>();

    int ans = 0;

    void parent(TreeNode curr, TreeNode prev) {

        mpp.put(curr, prev);

        if (curr.left != null) {

            parent(curr.left, curr);
        }

        if (curr.right != null) {

            parent(curr.right, curr);
        }
    }

    void rec(TreeNode curr) {

        if (curr == null) {

            return;
        }

        rec(curr.left);
        rec(curr.right);

        if (!seen.contains(curr)) {

            if (mpp.get(curr) != null) {

                TreeNode temp = mpp.get(curr);

                seen.add(temp);

                if (mpp.get(temp) != null) {

                    seen.add(mpp.get(temp));
                }

                if (temp.left != null) {

                    seen.add(temp.left);
                }

                if (temp.right != null) {

                    seen.add(temp.right);
                }
            } else {

                seen.add(curr);

                if (curr.left != null) {

                    seen.add(curr.left);
                }

                if (curr.right != null) {

                    seen.add(curr.right);
                }
            }

            ans++;
        }
    }

    public int minCameraCover(TreeNode root) {
    
        parent(root, null);

        rec(root);

        return ans;
    }
}