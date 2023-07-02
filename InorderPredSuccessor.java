import java.util.* ;
import java.io.*; 
import java.util.ArrayList.*;
/*************************************************************
    Following is the Binary Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/
/* Optimised approach :
1. traverse the BST 
2. compare the node with the key and update the successor and predecessor accordingly,
TC - O(Height of tree)
SC - O(1)
*/



public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
		ArrayList<Integer> res = new ArrayList<>(2); // 0 - pred , 1 - ucc
		res.add(0,-1);
		res.add(1,-1);

		while(root != null ){
			if(key > root.data){
				res.set(0,root.data);
				root = root.right;

			}
			else if (key < root.data) {
                		res.set(1, root.data); // Update successor
               			root = root.left;
            		} else {
	                // Key found, update both predecessor and successor and exit loop
	                if (root.left != null) {
	                    res.set(0, findMax(root.left));
	                }
	                if (root.right != null) {
	                    res.set(1, findMin(root.right));
	                }
	                break;
	            }
	        }

	        return res;
	}

    private static int findMax(BinaryTreeNode<Integer> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    private static int findMin(BinaryTreeNode<Integer> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
}
