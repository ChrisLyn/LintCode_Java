/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class ReverseKGroup {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (k >= 2) {
            ListNode prev = dummy;
            while (prev != null) {
                prev = reverseAndReturnNextPrev(prev, k);
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseAndReturnNextPrev(ListNode prev, int k) {
        ListNode lastPrev = prev;
        ListNode n1  = prev.next;
        
        ListNode nk = n1;
        for (int i = 0; i < k - 1; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        if (nk == null) {
            return null;
        }
        prev = null;
        ListNode nkPlus = nk.next;
        ListNode curr = n1;
        while (curr != nkPlus) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        lastPrev.next = nk;
        n1.next = nkPlus;
        return n1;
    }
    
    
}