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

public class Codec {
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        StringBuilder sb = new StringBuilder("");
        preorder(root,sb);
        return sb.toString(); 
    }
    public void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }        
        String[] temp = data.split(",");
        TreeNode root = dfs(temp);
        return root;
    }
    public TreeNode dfs(String[] temp){
        if(index >= temp.length){
            return null;
        }
        if(temp[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(temp[index++]));
        root.left = dfs(temp);
        root.right = dfs(temp);
        return root;

    }
}
