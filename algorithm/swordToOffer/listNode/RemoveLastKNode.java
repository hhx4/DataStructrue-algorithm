package algorithm.swordToOffer.listNode;

/**
 * 移除链表倒数第k个节点
 * Remove the kth node from the bottom of the linkedlistNode
 *
 **/
public class RemoveLastKNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode cur2 = head;
        ListNode res = cur2;
        while(cur!=null&&n>0){
            n--;
            cur = cur.next;
        }
        if(cur ==null){
            return head.next;
        }
        while(cur.next!=null){
            cur = cur.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return res;
    }
}