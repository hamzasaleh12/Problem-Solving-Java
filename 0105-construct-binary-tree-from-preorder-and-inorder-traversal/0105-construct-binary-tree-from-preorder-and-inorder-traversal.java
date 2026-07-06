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
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) map.put(inorder[i] , i);

        return helper(preorder , 0 , 0 , inorder.length - 1 , map);
    }
    private TreeNode helper(int[] preorder , int preStart , int inStart , int inEnd , Map<Integer,Integer> map) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]); // 3 , 9

        int m = map.get(root.val); // 1 , 0
        int leftSize = m - inStart; // 1 , 0

        root.left = helper(preorder , preStart + 1 , inStart , m - 1 , map); // leftside
        root.right = helper(preorder , preStart + leftSize + 1 , m + 1 , inEnd , map); // rightSide

        return root;
    }
}