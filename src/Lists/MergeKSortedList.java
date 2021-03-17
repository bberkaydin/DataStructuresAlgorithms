package Interview.Lists;

import java.util.*;

public class MergeKSortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(Comparator.comparingInt(x -> x.val)); // x.val - y.val
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            /*
            queue size will be always list.size() or less
            (i.e if 3 lists were sent as parameter then queue will be holding 3 nodes after first for loop) .
            But queue size will never be more than K , because we poll a node before we add another and
            we just add one node during each iteration.
            Ex:
            [
            1->4->5,
            1->3->4,
            2->6
            ]

            After first FOR loop, queue will contain 1,1,2.
            Now in the while loop, 1 (1st list) will be removed from queue and we test 1.next!=null and add 4 to the queue.
            so after 1st iteration queue will be 1,2,4.

            In the 2nd iteration, 1 ( 2nd list) will be removed from queue and test 1.next!=null (1.next is 3),
            add 3 to the queue. So queue will be 2,3,4 after this iteration and this continues,
            so the size of queue will always be <=K.
            */
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}