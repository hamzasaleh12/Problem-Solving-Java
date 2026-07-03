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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        helper(root , max);
        return max[0];
    }
    private int helper(TreeNode root , int[] max){
        if(root == null) return 0;
        int leftLength = helper(root.left , max); // 0
        int rightLength = helper(root.right , max); // 0

        max[0] = Math.max(max[0] , leftLength + rightLength);

        return 1 + Math.max(leftLength , rightLength);
    }
}