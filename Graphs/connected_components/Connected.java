import java.util.*;
import java.math.*;
public class Connected{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		ArrayList<Integer>[] adjlist = new ArrayList[v];
		for(int i=0;i<v;++i)adjlist[i] = new ArrayList<Integer>();
		int e = in.nextInt();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			adjlist[a].add(b);
			adjlist[b].add(a);
		}
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		int []visited = new int[v];
		int color = 1;
		for(int i=0;i<v;++i){
			if(visited[i]==0){
				dfs(i,adjlist,visited,color,map);
			}
			++color;
		}
		int i = 1;
		for(List<Integer> temp : map.values()){
			System.out.print(" component "+i+" : ");
			for(int k : temp)System.out.print(k+" ");
			System.out.println();
			++i;
		}
	}
	public static void dfs(int src,ArrayList<Integer>[] adjlist,int []visited,int color,HashMap<Integer,List<Integer>> map){
		visited[src] = 1;
		for(int i : adjlist[src]){
			if(visited[i]==0){
				dfs(i,adjlist,visited,color,map);
			}
		}
		map.putIfAbsent(color,new ArrayList<Integer>());
		map.get(color).add(src);
	}
}

