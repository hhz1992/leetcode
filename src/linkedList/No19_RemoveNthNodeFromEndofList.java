package linkedList;

/**
 * Created by Huanzhou on 2016/1/24.
 */
public class No19_RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        for(int i=0; i<=n;i++)
            fast = fast.next;

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        removeNthFromEnd(head,1);


    }

}
