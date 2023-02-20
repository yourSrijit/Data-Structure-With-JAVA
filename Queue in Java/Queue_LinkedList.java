package Queue_Java;
import java.util.Scanner;

public class Queue_LinkedList{

    public static class  Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next=null;
        }
    }
     public static Node rare=null;
     public static Node front=null;

     public static void Enqueue()
     {   Scanner sc =new Scanner(System.in);
         if(rare ==null && front ==null){
             System.out.println("Enter the data of new node");
             int node=sc.nextInt();
             Node new_node=new Node(node);
             front=new_node;
             rare=new_node;
         }
         else
         {   System.out.println("Enter the new node ->");
             int node=sc.nextInt();
             Node new_node1=new Node(node);
             rare.next=new_node1;
             rare=new_node1;
         }

     }
     public static void Dequeue(){
         if(front ==null){
             System.out.println("The queue is empty");
         }
         front=front.next;
     }
     public static void Display(){
         if(front ==null){
             System.out.println("The queue is empty");
         }
         else {
             Node ptr=front;
             int i=1;
             while (ptr!=null){
                 System.out.println("The "+i+" no elem is "+ptr.data);
                 ptr=ptr.next;
                 i++;
             }
         }
     }
        public static void main(String[] args) {
            while (true) {
                System.out.println("Enter\n 1:To Enqueue\n 2:To Deqeue \n 3:To Display\n 4:To exit");
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter your choice");
                int choice=sc.nextInt();

                switch (choice){
                    case 1:
                        Enqueue();
                        break;
                    case 2:
                        Dequeue();
                        break;
                    case 3:
                        Display();
                        break;
                    case 4:
                        System.out.println("Successfully Exit from the program");
                        System.exit(0);
                    default:
                        System.out.println("opps! Wrong entry try again");
                        break;
                }

            }
        }
}
