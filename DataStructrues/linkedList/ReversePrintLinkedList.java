package DataStructrues.linkedList;

import java.util.LinkedList;

/**
 * @author hw
 * @program mine learn
 * @description 逆序打印链表
 * @create 2021-04-12 10:31
 **/
public class ReversePrintLinkedList {
    //使用栈实现
    public void reversePrint(LinkedListnode head){
        if (head == null) {
            return;
        }
        LinkedListnode cur = head.next;
        LinkedList<LinkedListnode> linkedList = new LinkedList<>();
        while (cur != null) {
            linkedList.push(head);
            cur = cur.next;
        }
        System.out.println(linkedList.pop().val);
    }
}
