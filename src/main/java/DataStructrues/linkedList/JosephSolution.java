package DataStructrues.linkedList;

/**
 * @description 使用单链表解决的约瑟夫问题
 *              设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 *              它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。环形链表实现
 **/
public class JosephSolution {
    public static void main(String[] args) {
        // 测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addPerson(125);
        circleSingleLinkedList.printList();

        circleSingleLinkedList.countPer(10, 20, 125);
    }

}
class CircleSingleLinkedList {
    PersonNode first = null;

    /**
     *  构造环形链表
     */
    public void addPerson(int n){
        if(n < 1){
            throw new RuntimeException("输入的用户总数应大于1");
        }
        PersonNode cur = null;
        for (int i = 1; i <= n; i++) {
            PersonNode personNode = new PersonNode(i);
            if (i == 1) {
                first = personNode;
                first.next =first;
                cur = first;
            }else {
                cur.next = personNode;
                personNode.next =first;
                cur = personNode;
            }
        }
    }

    /**
    显示圈内人
     */
    public void printList(){
        if (first == null) {
            throw new RuntimeException("当前圈内无人");
        }
        PersonNode cur = first;
        while (true){
            System.out.println(cur.id);
            if(cur.next == first){
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * 打印出圈顺序
     */
    public void countPer(int k, int m, int n) {
        // 先对数据进行校验
        if (first == null || k < 1 || k > m) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        PersonNode helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            // 说明helper指向最后节点
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }
        //报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < k -1; j++) {
            first = first.next;
            helper = helper.next;
        }
        //报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 m - 1
            for(int j = 0; j < m - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            //这时first指向的节点，就是要出圈的节点
            System.out.println(first.id+"出圈");
            //这时将first指向的节点出圈
            first = first.next;
            helper.next = first;

        }
        System.out.println("最后留在圈中的编号："+ first.id);

    }
}

class PersonNode{
    int id;
    PersonNode next;
    public PersonNode(int id){
        this.id = id;
    }
}
