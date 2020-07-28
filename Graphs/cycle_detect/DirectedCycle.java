import java.util.*;
import java.math.*;
public class DirectedCycle{
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
		}
		int []visited = new int[v];
		int []path = new int[v];
		boolean flag = false;
		for(int i=0;i<v;++i){
			if(dfs(i,visited,adj_list,path)){
				flag = true;
				break;
			}
		}
		if(flag)System.out.println(" Cycle exists");
		else System.out.println(" No cycle");
	}
	public static boolean dfs(int src,int []visited,ArrayList<Integer>[] adj_list,int []path){
		if(path[src]==1)return true;
		if(visited[src] ==1)return false;
		visited[src] = 1;
		path[src] = 1;
		for(int i : adj_list[src]){
			if(dfs(i,visited,adj_list,path))return true;
		}
		path[src] = 0;
		return false;
	} 
}

