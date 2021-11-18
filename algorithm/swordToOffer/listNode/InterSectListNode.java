package algorithm.swordToOffer.listNode;

/**
 * 两个链表相交的交点，无焦点返回null
 * The intersection point where two linked lists intersect, return null if there is no focus
 *
 **/
public class InterSectListNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}