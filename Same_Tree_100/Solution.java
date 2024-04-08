package Same_Tree_100;
import TreeNode.TreeNode;
import java.util.Stack;
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
    // Approach is to use DFS iteratively
    // If at any point the values don't match or
    // the state of the stacks don't match we will return false
    // otherwise it will be true.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> previousRoots_1 = new Stack<>();
        Stack<TreeNode> previousRoots_2 = new Stack<>();
        boolean same = true;
        TreeNode current_1 = p, current_2 = q;
        // continue loop while there is something in the stack
        // or one of the currents point to a valid TreeNode
        while(!previousRoots_1.empty() || current_1 != null ||
                !previousRoots_2.empty() || current_2 != null){
            while(current_1 != null){
                previousRoots_1.push(current_1);
                current_1 = current_1.left;
            }
            while(current_2 != null){
                previousRoots_2.push(current_2);
                current_2 = current_2.left;
            }
            // neither stack should be empty at this point if one is
            // then they are not the same trees
            if(previousRoots_1.empty() || previousRoots_2.empty()){
                same = false;
                break;
            }
            TreeNode temp_1 = previousRoots_1.pop();
            TreeNode temp_2 = previousRoots_2.pop();
            if(temp_1.val != temp_2.val || previousRoots_1.size() != previousRoots_2.size()){
                same = false;
                break;
            }
            current_1 = temp_1.right;
            current_2 = temp_2.right;
        }
        return same;
    }
}
