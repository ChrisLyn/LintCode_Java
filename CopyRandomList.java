/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyRandomList {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
    
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode dummy = new RandomListNode(head.label);
            dummy.random = head.random;
            dummy.next = head.next;
            head.next = dummy;
            head = dummy.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null && head.next != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode split(RandomListNode head) {
        RandomListNode nHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return nHead;
    }
}