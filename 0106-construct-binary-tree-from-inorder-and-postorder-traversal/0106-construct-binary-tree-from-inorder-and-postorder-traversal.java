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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) map.put(inorder[i] , i);

        return helper(0 , postorder.length - 1 , 0 , inorder.length - 1 , postorder , map);
    }
    private TreeNode helper(int postStart , int postEnd , int inStart , int inEnd , int[] postorder , Map<Integer,Integer> map){
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = helper(postStart, postStart + leftSize - 1, inStart, inRoot - 1, postorder, map);
        root.right = helper(postStart + leftSize, postEnd - 1, inRoot + 1, inEnd, postorder, map);

        return root;
    }
}