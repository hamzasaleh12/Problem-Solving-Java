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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode node){
        if(node == null) return 0;

        int leftGain = Math.max(0, helper(node.left));
        int rightGain = Math.max(0, helper(node.right));

        maxSum = Math.max(maxSum , node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain , rightGain);
    }
}
