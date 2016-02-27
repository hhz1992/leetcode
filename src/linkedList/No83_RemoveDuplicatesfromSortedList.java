package linkedList;

/**
 * Created by Huanzhou on 2016/1/24.
 */
public class No83_RemoveDuplicatesfromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode pos = head;

        while(pos!=null){
            ListNode runner = pos.next;
            while(runner!=null && runner.val == pos.val)
                runner = runner.next;
            pos.next = runner;
            pos = pos.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode start = new ListNode(1);
        ListNode start1 = new ListNode(1);
        start.next = start1;
        deleteDuplicates(start);


    }


}
