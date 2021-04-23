package DataStructrues.linkedList.problem;

/**
 * @author hw
 * @program Java-master
 * @description 合并K个链表： leetcode23
 * @create 2021-04-23 17:17
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(0);
            if(l1.val <= l2.val){
                temp = l1;
                temp.next = mergeTwoLists(l1.next,l2);
            }else {
                temp.next = l2;
                temp.next = mergeTwoLists(l1, l2.next);
            }
        return temp;
    }
}