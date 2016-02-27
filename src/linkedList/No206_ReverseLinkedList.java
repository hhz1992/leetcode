package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head, prev = null;

        if(head == null)
            return head;

        while(cur !=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }











}
