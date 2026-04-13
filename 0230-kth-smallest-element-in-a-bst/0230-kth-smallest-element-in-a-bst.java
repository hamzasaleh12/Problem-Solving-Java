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
    public int kthSmallest(TreeNode root, int k) {
        int[] countAndRes = {0 , -1};
        helper(root , k , countAndRes);
        return countAndRes[1];
    }
    private void helper(TreeNode root, int k , int[] countAndRes){
        if(root == null || countAndRes[1] != -1) return;

        helper(root.left , k , countAndRes);
        
        if(++countAndRes[0] == k) {
            countAndRes[1] = root.val;
            return;
        }

        helper(root.right , k , countAndRes);
    }
}