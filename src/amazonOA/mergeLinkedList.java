package amazonOA;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class mergeLinkedList {
    public static CNode mergeTwoSortedList(CNode head1, CNode head2){
        CNode head = new CNode(0);
        CNode p = head;
        while(p != null){
            if(head1 == null){
                p.next = head2;
                break;
            }
            if(head2 == null){
                p.next = head1;
                break;
            }
            if(head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        return head.next;
    }
}
 class CNode {
    int val;
    CNode next;
    CNode(int x){
        this.val = x;
        this.next = null;
    }
}

