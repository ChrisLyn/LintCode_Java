/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class InsertIntoACyclicSortedList {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x >= prev.val && x <= p.val) {
                break;
            }
        } while (p != node);
        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return p;
    }
}