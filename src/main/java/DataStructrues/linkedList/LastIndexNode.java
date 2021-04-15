package DataStructrues.linkedList;

/**
 * @program mine learn
 * @description 找到链表的倒数第K个节点
 * @author hw
 * @create 2021-04-12 09:38
 **/
public class LastIndexNode {
    public LinkedListnode FindLastIndexNode(LinkedListnode listnode,int k){
        int length = 0;
        LinkedListnode cur = listnode.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        cur = listnode.next;
        for (int i = 0; i < length - k; i++) {
            cur=cur.next;
        }
        return cur;
    }
}