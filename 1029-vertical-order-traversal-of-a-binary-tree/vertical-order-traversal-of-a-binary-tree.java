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

    int min = (int)1e9;
    int max = -(int)1e9;

    int offset = -1;

    List<List<int[]>> ans = new ArrayList<>();

    void rec(TreeNode curr, int col) {

        min = Math.min(min, col);
        max = Math.max(max, col);

        if (curr.left != null) {

            rec(curr.left, col - 1);
        }

        if (curr.right != null) {

            rec(curr.right, col + 1);
        }
    }

    void sol(TreeNode curr, int row, int col) {

        ans.get(col + offset).add(new int[]{row, curr.val});

        if (curr.left != null) {

            sol(curr.left, row + 1, col - 1);
        }

        if (curr.right != null) {

            sol(curr.right, row + 1, col + 1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        rec(root, 0);

        int n = max - min + 1;
        offset = -min;

        for (int i = 0; i < n; i++) {

            ans.add(new ArrayList<>());
        }

        sol(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();

        for (List<int[]> curr : ans) {

            curr.sort((a, b) -> {

                if (a[0] != b[0]) {
                    
                    return a[0] - b[0];
                }
                
                return a[1] - b[1];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] x : curr) {
                
                temp.add(x[1]);
            }

            res.add(temp);
        }

        return res;
    }
}