package DataStructrues.queue;

import java.util.NoSuchElementException;

/**
 * @program: mine learn
 * @description:
 * @author: hw
 * @create: 2021-04-12 08:39
 **/
/*
* 使用链表实现的队列
* */
public class LinkedListQueueDemo {
        class Node {
            int data;
            Node next;

            public Node() {
                this(0);
            }

            public Node(int data) {
                this(data, null);
            }

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        /** 队头节点 */
        private Node front;

        /** 队尾节点 */
        private Node rear;

        /** 队列长度 */
        private int size;

        /** 初始化队列 */
        public LinkedListQueueDemo() {
            front = rear = new Node();
        }

        /**
         * 队列判空
         */
        public boolean isEmpty() {
            return size == 0;
        }
        /**
         * 入队
         * @return true表示成功
         */
        public boolean enqueue(int data) {
            Node newNode = new Node(data);
            rear.next = newNode;
            rear = newNode;
            size++;
            return true;
        }

        /**
         *出队
         * @return 队尾对象
         */
        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("队列为空");
            }
            //建立临时数据储存队首对象
            int retValue = front.next.data;
            front.next = front.next.next;
            size--;

            if (isEmpty()) {
                front = rear;
            }

            return retValue;
        }

        /**
         *队首元素
         * @return 队首元素
         */
        public int peekFront() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty");
            }
            return front.next.data;
        }

        /**
         *
         * @return 队尾对象
         */
        public int peekRear() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty");
            }
            return rear.data;
        }

        /**
         * @return 队列长度
         */
        public int size() {
            return size;
        }

        /** 清空队列 */
        public void clear() {
            while (!isEmpty()) {
                dequeue();
            }
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            StringBuilder builder = new StringBuilder();
            Node cur = front.next;
            builder.append("[");
            while (cur != null) {
                builder.append(cur.data).append(", ");
                cur = cur.next;
            }
            builder.replace(builder.length() - 2, builder.length(), "]");
            return builder.toString();
        }

        /* 测试方法 */
        public static void main(String[] args) {
            LinkedListQueueDemo queue = new LinkedListQueueDemo();

            System.out.println(queue.isEmpty());

            queue.enqueue(1);
            queue.enqueue(5);
            queue.enqueue(9);
            System.out.println(queue);

            System.out.println("队列长度"+queue.size());
            //出队一个
            queue.dequeue();
            System.out.println("队首元素"+queue.peekFront());
            System.out.println("队尾元素"+queue.peekRear());

            //清空队列
            queue.clear();
            queue.isEmpty();
            System.out.println(queue);
        }
}