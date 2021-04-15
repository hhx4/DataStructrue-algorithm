package DataStructrues.linkedList;

/**
 * @author hw
 * @program mine learn
 * @description 单链表的反转
 * @create 2021-04-12 09:46
 **/
public class ReverseLinkedList {
    public void reverseLinkedList(LinkedListnode head){
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个临时节点用于反转链表,这个节点不存储数据一直表示逆序链表的头节点
        LinkedListnode resListNode = new LinkedListnode(0);

        LinkedListnode cur =head.next;
        LinkedListnode next ;
        //遍历链表，每次遍历链表时需要把当前节点放在临时节点之前
        while (cur !=null){
            //先将下一个节点保存备份
            next = cur.next;
            //将当前节点的下一个值给变成逆序链表的非头节点第一个节点
            cur.next = resListNode.next;
            //使当前遍历节点cur成为逆序链表头节点后的第一个节点
            resListNode.next = cur;
            //原链表继续遍历
            cur = next;
        }

        head.next = resListNode.next;
    }
}