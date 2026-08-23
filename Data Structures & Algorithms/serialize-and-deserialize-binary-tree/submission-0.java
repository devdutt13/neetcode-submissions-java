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

    // Encodes a tree to a single string.
    private int index = 0;
    public String serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        StringBuilder sb = new StringBuilder("");
        dfs(root, sb);
        return sb.toString();
    
        
    }

    public void dfs(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        String[] values = data.split(",");

        return build(values);
        
    }
    public TreeNode build(String[] values){
        if(index >= values.length){
            return null;
        }
        if(values[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index++]));
        root.left = build(values);
        root.right = build(values);
        return root;
    }
}
