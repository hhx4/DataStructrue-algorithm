package algorithm.swordToOffer.listNode;

/**
 * 逆转链表
 * Reversal linked list
 **/
public class reverseListNode {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        ListNode reHead = new ListNode(0);
        ListNode tmp;
        while(cur!=null){
            tmp = cur.next;
            cur.next = reHead.next;
            reHead.next = cur;
            cur = tmp;
        }
        return reHead.next;
    }
}