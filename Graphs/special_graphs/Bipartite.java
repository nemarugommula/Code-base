import java.util.*;
import java.math.*;
public class Bipartite{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//if the vertices are integers use adjlist orther wise use hashmap
		ArrayList<Integer>[] adj_list = new ArrayList[n+1];
		for(int i=0;i<=n;++i)adj_list[i] = new ArrayList<Integer>();
		int E = in.nextInt();
		for(int i=0;i<E;++i){
			int a = in.nextInt();
			int b= in.nextInt();
			adj_list[a].add(b);
			adj_list[b].add(a);
		}
		int v = n;
		int []color = new int[v+1];
		int []visited = new int[v+1];
		if(bipartite(1,color,visited,0,adj_list)){
			System.out.println(" yes bipartite ");
		}else{
			System.out.println(" not bipartite ");
		}
	}
	public static boolean bipartite(int src,int []colors,int visited[],int color,ArrayList<Integer>[] adjlist){
		if(visited[src]==1){
			if(color!=colors[src])return false;
			return true;
		}
		visited[src] = 1;
		colors[src] = color;
		for(int i: adjlist[src]){
			if(!bipartite(i,colors,visited,color^1,adjlist)){
				return false;
			}
		}
		return true;
	}
}

