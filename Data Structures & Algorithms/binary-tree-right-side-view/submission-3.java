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
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> l = new ArrayList();
        if(root == null){
            return l;
        }
      
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode rightSide = null;
            for(int i=q.size(); i>0;i--){
                TreeNode temp = q.poll();
                if(temp != null){
                    rightSide = temp;
                    q.add(temp.left);
                    q.add(temp.right);
                }    
            }
            if(rightSide != null){
                l.add(rightSide.val);
            }

        }
        return l;
    }
}
