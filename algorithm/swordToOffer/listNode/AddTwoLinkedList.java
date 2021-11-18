package algorithm.swordToOffer.listNode;

import java.util.Stack;

/**
 * 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * Given two non-empty linked lists l1 and l2 to represent two non-negative integers.
 * The highest bit of the number is at the beginning of the linked list.
 * Each node of them only stores one digit. Adding these two numbers will return a new linked list.
 * It can be assumed that, except for the number 0, neither of these two numbers will start with a zero.
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
  **/
public class AddTwoLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = l1;
        while(cur != null){
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while(cur != null){
            stack2.push(cur.val);
            cur = cur.next;
        }
        ListNode newHead=new ListNode(-1);
        int carry=0;
        while (!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            int sum=carry;
            sum+=stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            carry=sum/10;
            ListNode cur2=new ListNode(sum%10);
            cur2.next=newHead.next;
            newHead.next=cur2;
        }
        return newHead.next;

    }
}