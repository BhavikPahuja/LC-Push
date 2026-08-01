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
    
    Map<TreeNode, TreeNode> mpp = new HashMap<>();

    void rec(TreeNode curr, TreeNode parent) {

        mpp.put(curr, parent);
    
        if (curr.left != null) {

            rec(curr.left, curr);
        }

        if (curr.right != null) {

            rec(curr.right, curr);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        rec(root, null);

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        for (int i=0; i<k; i++) {

            int len = q.size();

            for (int j=0; j<len; j++) {

                TreeNode curr = q.poll();
                vis.add(curr);

                if (curr.left != null && !vis.contains(curr.left)) {

                    q.offer(curr.left);
                }

                if (curr.right != null && !vis.contains(curr.right)) {

                    q.offer(curr.right);
                }

                if (mpp.get(curr) != null && !vis.contains(mpp.get(curr))) {

                    q.offer(mpp.get(curr));
                }
            }
        }

        while (!q.isEmpty()) {

            ans.add(q.poll().val);
        }

        return ans;
    }
}