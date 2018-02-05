/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class SortList {
    /*
     * Merge Sort
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return merge(slow, fast);
    }
    
    private ListNode merge(ListNode slow, ListNode fast) {
        if (slow == null && fast == null) {
            return null;
        } else if (slow == null) {
            return fast;
        } else if (fast == null) {
            return slow;
        }
        
        ListNode nHead = new ListNode(0);
        ListNode node = nHead;
        while (slow != null && fast != null) {
            if (slow.val > fast.val) {
                node.next = fast;
                fast = fast.next;
            } else {
                node.next = slow;
                slow = slow.next;
            }
            node = node.next;
        }
        
        if (slow == null) {
            node.next = fast;
        }
        if (fast == null) {
            node.next = slow;
        }
        return nHead.next;
    }
}