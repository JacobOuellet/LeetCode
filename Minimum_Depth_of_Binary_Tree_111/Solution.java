package Minimum_Depth_of_Binary_Tree_111;
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
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    //Approach is to use BFS and stop when we find our first leaf node.
    public int minDepth(TreeNode root) {
        if(root == null){return 0;}
        int level = 1, size;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            //first loop iterates down the tree keeping track of our level
            //second loop is used to iterate across the tree
            while(size != 0){
                TreeNode node = queue.remove();
                size--;
                if(node.left == null & node.right == null){return level;} // we are at min level
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
            }
            level++;
        }
        // we should never reach here, but if we do return nonsensical result.
        return -1;
    }
}
