import java.util.*;
import java.math.*;
public class Kosaraju{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v  = in.nextInt();
		ArrayList<Integer>[] adjlist = new ArrayList[v];
		ArrayList<Integer>[] rev_adjlist = new ArrayList[v];
		for(int i=0;i<v;++i){
			adjlist[i] = new ArrayList<Integer>();
			rev_adjlist[i] = new ArrayList<Integer>();
		}
		int e = in.nextInt();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			adjlist[a].add(b);
			rev_adjlist[b].add(a);
		}
		List<Integer> resource_list = new ArrayList<>();
		int []visited = new int[v];
		for(int i=0;i<v;++i){
			if(visited[i]==0){
				dfs(i,visited,adjlist,resource_list);
			}
		}
		Arrays.fill(visited,0);
		int color = 1;
		for(int i=v-1;i>=0;--i){
			int curr = resource_list.get(i);
			if(visited[curr]==0){
				recur(curr,visited,rev_adjlist,color);
			}
			++color;
		}
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		int k = 0;
		for(int i : visited){
			map.putIfAbsent(i,new ArrayList<Integer>());
			map.get(i).add(k);
			++k;
		}
		for(List<Integer> temp : map.values()){
			temp.forEach((i)->System.out.print(i+" "));
			System.out.println();
		}
	}
	public static void dfs(int src,int []visited,ArrayList<Integer>[] adjlist,List<Integer> resource_list){
		visited[src] = 1;
		for(int i : adjlist[src]){
			if(visited[i]==0){
				dfs(i,visited,adjlist,resource_list);
			}
		}
		resource_list.add(src);
	}
	public static void recur(int src,int []visited,ArrayList<Integer>[]adjlist,int color){
		visited[src]  = color;
		for(int i : adjlist[src]){
			if(visited[i]==0){
				recur(i,visited,adjlist,color);
			}
		}
	}
}

