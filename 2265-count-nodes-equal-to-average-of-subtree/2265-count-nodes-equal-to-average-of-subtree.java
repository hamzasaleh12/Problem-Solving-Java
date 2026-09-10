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
    private int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root); // o(n)
        return count;
    }
    private int[] dfs(TreeNode root){ // [0] -> sum , [1] -> count
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0]; // 1 + 0 + 0 = 0
        int numOfNodes = 1 + left[1] + right[1]; // 1 + 0 + 0 = 1

        if(sum / numOfNodes == root.val) count++; // 2

        return new int[]{sum , numOfNodes};
    }
}