package DataStructrues.linkedList;

/**
 * @program: mine learn
 * @description:
 * @author: hw
 * @create: 2020-11-15 19:43
 **/
public class LinkedListDemo {
//头节点
    LinkedListnode head;
    //尾节点
    LinkedListnode rear;
    int size;

    public int size() {
        return size;
    }

//这里为了方便实现直接构建了两个虚拟的节点，不计入size中
    public LinkedListDemo() {
        head = new LinkedListnode(0);
        rear = new LinkedListnode(0);
        size = 0;
    }

    //获取指定节点值
    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        //这里需要遍历节点以得到所求索引值
        return getNode(index).val;
    }
//获取链表的节点
    private LinkedListnode getNode(int index) {
        LinkedListnode temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(Object val) {
        //第一次添加
        if (head.next == null) {
            LinkedListnode newHead = new LinkedListnode(val);
            head.next = newHead;
            rear.pre = newHead;
        } else {
            LinkedListnode oldHead = head.next;

            LinkedListnode newHead = new LinkedListnode(val);
            newHead.pre = head;
            newHead.next = oldHead;
            head.next = newHead;
            oldHead.pre = newHead;
        }
        size++;
    }

    //将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        //第一次添加
        if (rear.pre == null) {
            LinkedListnode newHead = new LinkedListnode(val);
            newHead.pre = head;
            newHead.next = rear;
            head.next = newHead;
            rear.pre = newHead;
        } else {
            LinkedListnode oldTail = rear.pre;

            LinkedListnode newTail = new LinkedListnode(val);
            newTail.next = rear;
            newTail.pre = oldTail;
            oldTail.next = newTail;
            rear.pre = newTail;
        }
        size++;

    }

    //在链表中的第index个节点之前添加值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
// 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        // 如果 index 大于链表长度，则不会插入节点。
        if (index > size) {
            return;
            //如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        } else if (index == size) {
            addAtTail(val);
            // 如果index小于0，则在头部插入节点。
        } else if (index < 0) {
            addAtHead(val);
            //插到中间的情况
        } else {
            LinkedListnode oldNode = getNode(index);
            LinkedListnode oldNodePre = oldNode.pre;
            LinkedListnode newNode = new LinkedListnode(val);
            newNode.pre = oldNodePre;
            newNode.next = oldNode;
            oldNode.pre = newNode;
            oldNodePre.next = newNode;
            size++;
        }

    }

    //如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
//index无效
        if (index < 0 || index > size - 1 || size <= 0) {
            return;
        }
        //要删除的节点
        LinkedListnode node = getNode(index);
        LinkedListnode nodePre = node.pre;
        LinkedListnode nodeNext = node.next;

        nodePre.next = nodeNext;
        nodeNext.pre = nodePre;
        size--;
    }

    public static void main(String[] args) {
        LinkedListDemo list=new LinkedListDemo();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(6);
        list.deleteAtIndex(5);
        System.out.println(list.size());
        System.out.println(list.get(4));
    }
}

class LinkedListnode {
    //节点前指针域
    LinkedListnode pre;
    //节点指针域
    LinkedListnode next;
    //数据
    Object val;

    public LinkedListnode(Object val) {
        this.val = val;
    }
}



