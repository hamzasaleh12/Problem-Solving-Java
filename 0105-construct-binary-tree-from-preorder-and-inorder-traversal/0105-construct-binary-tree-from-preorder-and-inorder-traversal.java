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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) map.put(inorder[i] , i);

        return helper(0 , preorder.length - 1 , 0 , inorder.length - 1 , preorder , map);
    }
    private TreeNode helper(int preStart , int preEnd , int inStart , int inEnd , int[] preorder , Map<Integer , Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = helper(preStart + 1 , preStart + leftSize , inStart , inRoot - 1 , preorder , map);
        root.right = helper(preStart + leftSize + 1 , preEnd , inRoot + 1 , inEnd , preorder , map);

        return root;
    }
}