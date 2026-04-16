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
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                str.append("null,");
                continue;
            }
            str.append(temp.val).append(",");
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    // [1,2,3,null.null,4,5,null.null]
    public TreeNode deserialize(String data) {
        if(data.equals("null,")) return null;

        String[] strs = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();

            if(!strs[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(strs[i]));
                parent.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            
            if(!strs[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(strs[i]));
                parent.right = rightNode;
                queue.add(rightNode);
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