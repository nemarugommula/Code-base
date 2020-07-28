import java.util.*;
import java.math.*;
public class BFS{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		//if the vertices are integers use adjlist orther wise use hashmap
		ArrayList<Integer>[] adj_list = new ArrayList[v];
		for(int i=0;i<v;++i)adj_list[i] = new ArrayList<Integer>();
		int E = in.nextInt();
		for(int i=0;i<E;++i){
			int a = in.nextInt();
			int b= in.nextInt();
			adj_list[a].add(b);
			adj_list[b].add(a);
		}
		int []visited = new int[v];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = 1;
		while(!q.isEmpty()){
			int curr = q.remove();
			System.out.print(" visited : "+curr);
			for(int i : adj_list[curr]){
				if(visited[i]==0){
					q.add(i);
					visited[i] = 1;
				}
			}
		}
		
	}
}

