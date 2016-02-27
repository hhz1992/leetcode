package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;

        while(cur.next !=null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else
                cur = cur.next;
        }

        return fake.next;

    }


    public static void main(String[] args) {

    }
}
