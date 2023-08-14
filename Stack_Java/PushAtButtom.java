package Stack_Java;

import java.util.Stack;

public class PushAtButtom {
    public static void pushAtButtom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtButtom(data,s);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushAtButtom(5,s);

        while (!s.isEmpty()){
            System.out.print(s.pop()+" -> ");
        }
    }
}
