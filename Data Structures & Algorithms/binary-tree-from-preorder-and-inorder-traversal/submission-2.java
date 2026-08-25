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
    private int index = 0;
    Map<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return solve(preorder,0,inorder.length-1);

    }
    public TreeNode solve(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int mid = mp.get(preorder[index]);
        index++;
        root.left = solve(preorder,left,mid-1);
        root.right = solve(preorder,mid+1,right);
        return root;

    }
}
