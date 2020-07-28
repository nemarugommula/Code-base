import java.util.*;
import java.math.*;
class Node{
	int val;
	Node next;
	public Node(int val){
		this.val = val;
		next = null;
	}
}
public class LinkedList{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = new Node(-1);
		Node temp = root;
		for(int i=0;i<n;++i){
			temp.next= new Node(in.nextInt());
			temp = temp.next;
		}
		tail_reverse(root.next);
		Node ans = reverse(root.next);
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
		System.out.println();
	}
	// Iterative reversing
	public static Node reverse(Node root){
		Node temp = root;
		Node prev = null;
		while(temp!=null){
			Node next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;	
		}
		return prev; 
	}
	//Recursive version
	public static void tail_reverse(Node root){
		if(root==null)return;
		tail_reverse(root.next);
		System.out.print(root.val+" ");
	}
}

