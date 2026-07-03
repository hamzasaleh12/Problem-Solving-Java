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
    public boolean isValidBST(TreeNode root) {
        return helper(root , null , null); // 5
    }
    private boolean helper(TreeNode root , TreeNode max , TreeNode min){ // 2 , 2 , null
        if(root == null) return true;
        
        if((max != null && root.val >= max.val) || (min != null && root.val <= min.val)) return false;

        return helper(root.left , root , min) && helper(root.right , max , root);
    }
}