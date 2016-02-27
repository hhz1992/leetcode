package linkedList;

/**
 * Created by Huanzhou on 2016/1/24.
 */
public class No21_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

       // ListNode pos = (l1.val >= l2.val )? l1:l2;
        ListNode pos;

        if(l1 ==null)
            return l2;
        else if(l2 ==null)
            return l1;

        if(l1.val <= l2.val) {
            pos = l1;
            l1 = l1.next;
        }
        else {
            pos = l2;
            l2 = l2.next;
        }

        ListNode result = pos;

        while(l1!=null && l2!=null){

            if(l1.val <= l2.val){
                pos.next = l1;
                l1 = l1.next;
            }else{
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }

        if(l1 == null)
            pos.next = l2;

        if(l2 == null)
            pos.next = l1;

        return result;
    }



    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);

        mergeTwoLists(l1,l2);


    }


}



