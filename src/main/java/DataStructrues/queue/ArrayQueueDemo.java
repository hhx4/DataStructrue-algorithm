package DataStructrues.queue;

/**
 * @author hw
 * @program mine learn
 * @description 数组实现环形队列
 * @create 2021-04-06 16:11
 **/
public class ArrayQueueDemo {
    // 数据
    private int[] data;
    // 头尾指针
    private int pStart;
    private int pEnd;
    //容量
    private int size;

    public ArrayQueueDemo(int arrMaxSize) {
        size = arrMaxSize;
        data = new int[size];
        pStart = 0;
        pEnd = 0;
    }

    public boolean isFull() {
        return pStart == (pEnd + 1) % size;
    }

    public boolean isEmpty() {
        return pStart == pEnd;
    }

    //入队
    public void enQueue(int x) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        data[pEnd] = x;
        pEnd = (pEnd + 1) % size;
    }

    //出队
    public int deQueue() {
        //判空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = data[pStart];
        pStart = (pStart + 1) % size;
        return value;
    }


    public int size(){
        return (pEnd+size-pStart)%size;
    }

    //取得队首数据
    public int getpStart() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空无数据");
        }
        return data[pStart];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = pStart; i <pStart+size() ; i++) {
            builder.append(data[i%size]).append(", ");
        }
        builder.replace(builder.length() - 2, builder.length(), "]");
        return builder.toString();
    }

    public static void main(String[] args) {

        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(16);

        arrayQueueDemo.enQueue(1);
        arrayQueueDemo.enQueue(2);
        arrayQueueDemo.enQueue(3);
        arrayQueueDemo.deQueue();

        System.out.println("队首元素"+arrayQueueDemo.getpStart());
        System.out.println(arrayQueueDemo);
        System.out.println("是否为空:"+arrayQueueDemo.isEmpty());
    }
}