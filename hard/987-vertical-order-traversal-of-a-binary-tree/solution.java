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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        //fill nodes list
        dfs(root, 0, 0, nodes);
        nodes.sort((a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        }
        );
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for(int[] node: nodes){
            int col= node[1], val = node[2];
            if(col!=prevCol){
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size()-1).add(val);
        }
        return result;
    }
    private void dfs(TreeNode root, int row, int col, List<int[]> nodes){
        if(root == null) return;
        nodes.add(new int[]{row, col, root.val});
        dfs(root.left, row+1, col-1, nodes);
        dfs(root.right, row+1, col+1, nodes);
    }
}