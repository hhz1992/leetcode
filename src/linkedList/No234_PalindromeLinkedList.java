package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No234_PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

        ListNode p1 = head, p2 = head;
        ListNode p3 = p1.next, prev = p1;

        if(head == null) {
            return true;
        }

        while(p2.next != null && p2.next.next !=null){
            p2 = p2.next.next;
            prev = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = prev;

         }

        if(p2.next== null){
            p1 = p1.next;
        }

        while(p3!=null) {
            if (p1.val != p3.val)
                return false;
            p3 = p3.next;
            p1 = p1.next;

        }
        return true;


    }



    public static void main(String[] args) {

        ListNode p1 = new ListNode(1);
        ListNode p2= new ListNode(0);
        ListNode p3 = new ListNode(0);

        p1.next = p2;
        p2.next = p3;
        p3.next = null;

        System.out.println(isPalindrome(p1));




    }
}
