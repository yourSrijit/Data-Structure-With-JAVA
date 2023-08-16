package Stack_Java;

import java.util.Stack;

public class reverseStack {
    public static void printStack(Stack<Integer> stack){
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void pushBottom(Stack<Integer> stack,int data){
        if(stack.isEmpty()){
           stack.push(data);
           return;
        }
        int top=stack.pop();
        pushBottom(stack,data);
        stack.push(top);
    }
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top=stack.pop();
        reverseStack(stack);
        pushBottom(stack,top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
//        printStack(stack);
        reverseStack(stack);
        printStack(stack);
    }
}
