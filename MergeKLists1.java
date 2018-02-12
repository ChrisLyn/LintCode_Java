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
public class MergeKLists1 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        if (lists.size() == 1) {
            return lists.get(0);
        }
        Queue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (ListNode head: lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode nHead = new ListNode(0);
        ListNode node = nHead;
        while (queue.size() > 0) {
            ListNode tmp = queue.poll();
            node.next = tmp;
            if (tmp.next != null) {
                queue.offer(tmp.next);
            }
            node = node.next;
        }
        return nHead.next;
    }
}
