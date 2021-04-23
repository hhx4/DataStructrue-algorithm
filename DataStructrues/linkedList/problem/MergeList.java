package DataStructrues.linkedList.problem;

/**
 * @author hw
 * @program Java-master
 * @description 合并有序链表 leetcode21
 * @create 2021-04-23 17:03
 **/
public class MergeList {
    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(cur1 != null&&cur2 != null){
            if(cur1.val <= cur2.val){
                temp.next = cur1;
                temp = cur1;
                cur1 = cur1.next;
            }else{
                temp.next = cur2;
                temp = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 == null){
            temp.next = cur2;
        }else {
            temp.next = cur1;
        }
        return ans;
    }
}