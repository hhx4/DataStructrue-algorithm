package DataStructrues.linkedList.problem;

/**
 * @description 求链表交点，已知两链表相交，并知道两链表的头节点160
 **/
public class GetIntersectionNode {
    public ListNode getInterSectionNode(ListNode l1,ListNode l2){
        int gap = getLength(l1 ) - getLength(l2);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(gap > 0){
            foward_long_list(gap, cur1);
        }else if(gap < 0){
           foward_long_list(-gap,cur2);
        }
        while (cur1 != null&&cur2 != null){
            if(cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public void foward_long_list(int gap, ListNode node) {
        while (node != null&& gap > 0) {
            node = node.next;
            gap--;
        }
    }

    public int getLength(ListNode head){
        ListNode cur = head;
        int sum = 0;
        while (cur != null){
            cur = cur.next;
            sum++;
        }
        return sum;
    }

}
class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}