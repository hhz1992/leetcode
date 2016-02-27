package linkedList;

/**
 * Created by Huanzhou on 2016/1/25.
 */
public class No237_DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }


}
