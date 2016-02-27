package array;

import linkedList.ListNode;

/**
 * Created by Huanzhou on 2016/2/6.
 */
public class No2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode l3 = head;

        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){

            int sum = ((l1!=null)?l1.val:0) + ((l2!=null)?l2.val:0) + carry;
            ListNode node = new ListNode(sum%10);
            carry = (sum/10==0?0:1);
            l3.next = node;
            l3 = node;

            l1 = (l1==null?l1:l1.next);
            l2 = (l2==null?l2:l2.next);

        }
        return head.next;

    }


}
