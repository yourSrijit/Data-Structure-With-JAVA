package Stack_Java;

import java.util.Scanner;
import java.util.Stack;

public class reverseString {
    public static String reverse(Stack<Character> stack,String str){
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        String res=" ";
        while (!stack.isEmpty()){
            res=res+stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        System.out.println("Enter the string");
        String str=new Scanner(System.in).nextLine();
        System.out.println("Reverse is "+reverse(stack,str));
    }
}
