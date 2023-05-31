package com.xx.test.algorithm;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String token : tokens) {
            // 是符号，则从栈中取出前两位进行运算
            if (isOp(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(token.equals("+")) {stack.push(num1 + num2);}
                else if(token.equals("-")) {stack.push(num1 - num2);}
                else if(token.equals("*")) {stack.push(num1 * num2);}
                else {stack.push(num1 / num2);}
            }
            // 数字则入栈
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public boolean isOp(String str) {
        int size = str.length();
        if (size > 1) {return false;}
        char digi = str.charAt(0);
        return digi < '0' || digi > '9';
    }
}
