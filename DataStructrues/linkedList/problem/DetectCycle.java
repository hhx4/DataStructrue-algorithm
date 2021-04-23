package DataStructrues.linkedList.problem;

/**
 * @author hw
 * @program Java-master
 * @description 链表求环起始节点  leetcode141
 * @create 2021-04-23 11:57
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null ){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            slow = slow.next;

            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if (meet == null){
            return meet;
        }
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}