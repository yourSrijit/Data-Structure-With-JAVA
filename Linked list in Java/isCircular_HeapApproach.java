import java.util.*;
class Main {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
    public static Node head=null;
	public static Node insertion(int data){
		if(head==null){
			head=new Node(data);
			return head;
		}
		Node cur=new Node(data);
		cur.next=head;
		head=cur;
		return head;
	}
	public static Node isCircular(Node head){
		HashMap<Integer,Integer> map=new HashMap<>();
		Node current=head;
		while(current!=null){
			if(map.containsKey(current.data)){
				return current;
			}
			map.put(current.data,1);
	        current=current.next;
		}
		return null;
	}
  public static void main(String[] args) {
	  head=insertion(10);
	  insertion(50);
	  insertion(30);
	  insertion(20);
	  insertion(15);
	  insertion(25);
	  insertion(20);

	  Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
	  Node x=isCircular(head);
	  if(x!=null){
		  System.out.println("Circle is present at node "+x.data);
	  }
	  else{
		  System.out.println("Circle is not present");
	  }
	  
    
  }
}
