package DataStructrues.linkedList.problem;

/**
 * @author hw
 * @program Java-master
 * @description 划分链表 leetcode86
 * @create 2021-04-23 12:12
 **/
public class Partition {
    public ListNode partition(ListNode head,int x){
        ListNode lessNode = new ListNode(0);
        ListNode moreNode = new ListNode(0);
        ListNode less =lessNode;
        ListNode more = moreNode;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = head;
            }else {
                more.next = head;
                more = head;
            }
            head = head.next;
        }
        less.next = moreNode.next;
        more.next = null;
        return lessNode.next;
    }
}