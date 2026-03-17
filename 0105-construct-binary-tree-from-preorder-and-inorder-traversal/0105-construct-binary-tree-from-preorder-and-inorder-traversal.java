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
    Map<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return helper(0 , 0 , inorder.length - 1 , preorder);
    }
    private TreeNode helper(int preStart ,int inStart , int inEnd ,int[] preorder){
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int mid = map.get(root.val);
        int leftSize = mid - inStart;

        root.left = helper(preStart + 1 , inStart , mid - 1 , preorder);
        root.right = helper(preStart + leftSize + 1 , mid + 1, inEnd , preorder);
        
        return root;
    }
}
