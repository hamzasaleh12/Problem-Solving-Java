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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }
    private int helper(TreeNode node){
        if(node == null) return 0;

        int leftHeight = helper(node.left); // 1 
        int rightHeight = helper(node.right); // 2 

        if(Math.abs(leftHeight - rightHeight) > 1) isBalanced = false; // f , f , f , f , f

        return 1 + Math.max(leftHeight , rightHeight); // 1 , 1 , 1 , 2 , 3
    }
}
