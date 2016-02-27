package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No160_IntersectionofTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode posA = headA, posB = headB;

        while(posA!=posB){

           posA = (posA==null)? headB: posA.next;
           posB = (posB==null)? headA: posB.next;

        }

        return posA;

    }

}
