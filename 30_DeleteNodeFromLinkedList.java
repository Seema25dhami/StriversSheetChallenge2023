import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/
/* Node is the target node to be deleted from the linkedlist */

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        int nextData = node.next.data;
        node.next = node.next.next;
        node.data = nextData;
	}
}
