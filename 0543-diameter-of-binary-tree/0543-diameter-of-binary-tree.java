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
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calHight(root);
        return maxDepth;
    }
    private int calHight(TreeNode node){
        if(node == null) return 0;

        int leftHight = calHight(node.left); // 0 , 1  , 2
        int rightHight = calHight(node.right); // 0 , 1 , 1

        maxDepth = Math.max(maxDepth , leftHight + rightHight); // 0 , 0 + 0 , 1 + 1 = 2 , 2 + 1 = 3

        return 1 + Math.max(leftHight,rightHight); // 1 , 2 , 3
    }
}