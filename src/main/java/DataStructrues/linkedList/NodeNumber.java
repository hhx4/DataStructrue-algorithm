package DataStructrues.linkedList;

/**
 * @program: mine learn
 * @description: 求链表节点个数
 * @author: hw
 * @create: 2021-04-12 09:29
 **/
public class NodeNumber {
    public int getLength(LinkedListnode listnode){
        if(listnode.next == null){
            return 0;
        }
        //找到链表的头节点
        int length = 0;

        LinkedListnode cur = listnode.next;
        while (cur != null){
            length++;
            cur=cur.next;
        }
        return length;
    }
}