package DataStructrues.linkedList.problem;

/**
 * @author hw
 * @program Java-master
 * @description 节点带随机指针的链表拷贝  leetcode138
 * @create 2021-04-23 16:36
 **/
public class RandomListCopy {
    public Node randomListNode(Node head){
        if(head ==null){
            return head;
        }
        Node cur = head;
        while(cur != null){
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            Node temp = cur.next;
            cur.next = clone;
            cur = temp;
        }
        cur = head;
        while (cur != null){
            cur.next.random = cur.random ==null?null:cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node cloneHead = head.next;
        while (cur.next != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return cloneHead;
    }
}
class Node {
    int val;
    Node next = null,random = null;
    public Node(int val) {
        this.val = val;
    }
}