package linkedList;

/**
 * Created by Huanzhou on 2016/1/24.
 */
public class No82_RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode fake = new ListNode(0);
        ListNode cur = head;
        ListNode prev = fake;
        prev.next = head;

        while (cur != null) {

            while (cur.next != null && cur.val == cur.next.val)
                cur = cur.next;

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return fake.next;

    }
}
