/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) {

            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();

            if (curr == null) {

                sb.append("#,");
            } else {

                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data.equals("")) {

            return null;
        }

        String val[] = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < val.length) {
            
            TreeNode curr = q.poll();

            if (!val[i].equals("#")) {
            
                curr.left = new TreeNode(Integer.parseInt(val[i]));
                q.offer(curr.left);
            }
            
            i++;

            if (i < val.length && !val[i].equals("#")) {
            
                curr.right = new TreeNode(Integer.parseInt(val[i]));
                q.offer(curr.right);
            }
            
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));