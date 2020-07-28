import java.util.*;
import java.math.*;
public class DFS{
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
		dfs(0,visited,adj_list);
	}
	public static void dfs(int src,int []visited,ArrayList<Integer>[] adj_list){
		visited[src] = 1;
		System.out.println(" visited : "+src);
		for(int i : adj_list[src]){
			if(visited[i]==0){
				dfs(i,visited,adj_list);
			}
		}
	} 
}

