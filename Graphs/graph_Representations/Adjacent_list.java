import java.util.*;
import java.math.*;
public class Adjacent_list{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//if the vertices are integers use adjlist orther wise use hashmap
		ArrayList<int[]>[] adj_list = new ArrayList	[n+1];
		for(int i=0;i<=n;++i)adj_list[i] = new ArrayList<int[]>();
		int E = in.nextInt();
		for(int i=0;i<E;++i){
			int a = in.nextInt();
			int b= in.nextInt();
			int cost = in.nextInt();
			adj_list[a].add(new int[]{b,cost});
			//if bidirectional 
			adj_list[b].add(new int[]{a,cost});
		}
	}
}

