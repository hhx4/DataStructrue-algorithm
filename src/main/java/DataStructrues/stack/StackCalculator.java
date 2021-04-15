package DataStructrues.stack;

import java.util.LinkedList;

/**
 * @description 使用栈模拟的计算器
 **/
public class StackCalculator {
    public static void main(String[] args) {
        StackCalculator s = new StackCalculator();
        int i = s.stackCalculator("7*2*2-5+1-5+3-4");
        System.out.println(i);
    }

    public int stackCalculator(String s) {
        //定义数字栈和符号栈
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> operStack = new LinkedList<>();
      /*  遍历表达式，数字入数栈，符号进行判断，符号栈为空入符号栈，如果栈中有操作符，
         1、则比较优先级小于或者等于栈中的，就从数栈中去除两个数，再从符号栈中pop出一个符号运算得到结果入数栈，在将当前操作符入栈；
        2、如果当前操作符优先级高则直接入栈
        当表达式扫描完毕，就顺序从数栈中取出符号和数计算，最后栈中的数字就是结果
        */
        int index = 0;
        String keepNum = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isOper(c)){
                if (operStack.isEmpty()) {
                    operStack.addFirst(c);
                }else {
                    if (priority(c)<priority(operStack.getFirst())) {
                         int num1 = numStack.removeFirst();
                         int num2 = numStack.removeFirst();
                         char operator = operStack.removeFirst();
                         numStack.addFirst(cal(num1,num2,operator));
                         operStack.addFirst(c);
                    }else {
                        operStack.addFirst(c);
                    }
                }
            }else {
                keepNum += c;

                //如果ch已经是expression的最后一位，就直接入栈
                if (index == s.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{

                if(isOper(c)){
                    numStack.addFirst(Integer.valueOf(keepNum));
                    keepNum = "";
                }
                }
            }
        }
        while (!operStack.isEmpty()) {
            int a= numStack.pop();
            int b = numStack.removeFirst();
            char c =operStack.removeFirst();
            int cal = cal(a,b ,c );
            numStack.addFirst(cal);
        }
        return numStack.getFirst();
    }
    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public int priority(int oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}