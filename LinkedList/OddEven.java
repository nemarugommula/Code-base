import java.util.*;
import java.math.*;
	class Node{
		int data;
		Node next;
		public Node(int val){
			data = val;
			next = null;
		}
	}
public class OddEven{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Node dummy = new Node(-1);
		int n = in.nextInt();
		Node temp = dummy;
		for(int i=0;i<n;++i){
			temp.next = new Node(in.nextInt());
			temp = temp.next;
		}
		Node ans = solution(dummy.next);
		while(ans!=null){
			System.out.println(ans.data+" ");
			ans = ans.next;
		}	
	}
	public static Node solution(Node root){
		if(root==null)return root;
		Node dummy = new Node(-1);
		Node ret = dummy;
		Node prev = null;
		Node curr = root;
		int pos = 1;
		Node even = null;
		while(curr!=null){
			if(pos%2!=0){
				//odd node
				dummy.next = curr;
				dummy = dummy.next;
				if(prev!=null){
					prev.next = curr.next;
				}
			}else{
				//even node
				if(even==null)even = curr;
				prev = curr;
			}
			curr = curr.next;
			++pos;
		}
		dummy.next = even;
		return ret.next;
	} 
}