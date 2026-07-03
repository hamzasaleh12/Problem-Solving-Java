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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = {true};
        isBalancedHelper(root , isBalanced);
        return isBalanced[0];
    }
    private int isBalancedHelper(TreeNode root , boolean[] isBalanced){
        if(!isBalanced[0] || root == null) return 0;

        int leftLength = isBalancedHelper(root.left , isBalanced);
        int rightLength = isBalancedHelper(root.right , isBalanced);

        if(Math.abs(rightLength - leftLength) > 1) isBalanced[0] = false;

        return 1 + Math.max(leftLength , rightLength);
    }
}