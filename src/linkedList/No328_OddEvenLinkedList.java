package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next, oddHead = odd, evenHead = even;

        while( even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
            odd.next = evenHead;

        return oddHead;
    }


}
