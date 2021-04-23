package DataStructrues.stack;

import java.util.Arrays;

/**
 * @description 使用数组实现的可扩容栈
 **/
public class ArrayStackDemo {
    // 向栈当中存储元素,存到栈中，就表示存储到数组中。
    // Object类型数组可以存储java中的任何引用类型的数据
    private Object[] elements;
    // 栈帧，永远指向栈顶部元素
    //private int index = 0; // 如果index采用0，表示栈帧指向了顶部元素的上方。
    //private int index = -1; // 如果index采用-1，表示栈帧指向了顶部元素。
    private int top;
    //无参数构造方法。默认初始化栈容量10.
    public ArrayStackDemo() {
        // 默认初始化容量是10.
        this.elements = new Object[10];
        // 给index初始化
        this.top = -1;
    }
    //指定容量的有参初始构造
    public ArrayStackDemo(int capacity) {
        // 默认初始化容量是10.
        this.elements = new Object[capacity];
        // 给top初始化
        this.top = -1;
    }
    //压栈
    public void push(Object obj){
        if(top >= elements.length - 1){
            //扩容每次容量翻倍
            elements=grow(elements);
        }
        // 向栈中加1个元素，栈帧向上移动一个位置。
        top++;
        elements[top] = obj;
        //压栈测试
//        System.out.println("压栈" + obj + "元素成功，栈帧指向" + index);
    }
    public int size(){
        return top+1;
    }
    private Object[] grow(Object[] elements) {
        Object[] newE;
        newE = Arrays.copyOf(elements,elements.length*2);
        return newE;
    }

    //弹栈
    public Object pop() throws MyStackOperationException {
        if(top < 0){
            throw new MyStackOperationException("弹栈失败，栈已空！");
        }

        //  System.out.print("弹栈" + elements[index] + "元素成功，");//弹栈测试
        // 栈帧向下移动一位。
        top--;
        //返回为删除值
        return elements[top +1];
    }
    //判空
    public boolean isEmpty(){
        //栈帧为-1 时栈空
        if(top <0){
            return true;
        }
        return false;
    }
    //取栈顶元素
    public Object peek() throws MyStackOperationException {
        if(top < 0){
            throw new MyStackOperationException("弹栈失败，栈已空！");
        }
        return elements[top];
    }
    //清空栈
    public void clear(){
        //重构一次
        this.elements = new Object[10];
        this.top = -1;
    }


    public Object[] getElements() {

        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
//自定义栈空异常
class MyStackOperationException extends Exception{

    public MyStackOperationException(){

    }

    public MyStackOperationException(String s){
        super(s);
    }

}