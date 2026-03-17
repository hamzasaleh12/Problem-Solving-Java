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
    Queue<TreeNode> queue = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder str = new StringBuilder();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null){
                str.append("null").append(",");
                continue;
            }

            str.append(curr.val).append(",");

            queue.add(curr.left);
            queue.add(curr.right);
        }
        return str.toString();
    }
    // "1,2,3,null,null,4,5,null,null"

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int i = 1;
        while(i < values.length && !queue.isEmpty()){
            TreeNode parent = queue.poll();

            parent.left = (values[i].equals("null")) ? null : new TreeNode(Integer.parseInt(values[i]));
            if(parent.left != null) queue.add(parent.left);
            i++;

            if(i < values.length){
                parent.right = (values[i].equals("null")) ? null : new TreeNode(Integer.parseInt(values[i]));
                if(parent.right != null) queue.add(parent.right);
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