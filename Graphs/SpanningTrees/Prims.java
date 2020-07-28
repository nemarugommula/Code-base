//heaps din't work because we need dynamic sorting it occurs only when ever we insert a new item
//it fails if we add all vertices first and later change the attributes of the sorting deciders

import java.util.*;
import java.math.*;
public class Prims{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		List<List<int[]>> adjlist= new ArrayList<>();
		for(int i=0;i<v;++i){
			adjlist.add(new ArrayList<int[]>());
		}
		int e = in.nextInt();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			adjlist.get(a).add(new int[]{b,cost});
			adjlist.get(b).add(new int []{a,cost});
		}
		int ans = spanning(adjlist,v);
		System.out.println(" ans : "+ans);
	}
	public static int spanning(List<List<int[]>> adjlist,int v){
		int []parent = new int[v];
		parent[0] = -1;
		int []cost = new int[v];
		Arrays.fill(cost,inf);
		cost[0] = 0;
		List<Integer> nodes = new ArrayList<>();
		TreeSet<Integer> pq = new TreeSet<>((a,b)->(cost[a]-cost[b]));
		pq.add(0);
		int []visited = new int[v];
		int counter = 0;
		while(!pq.isEmpty()){
			int curr = pq.first();
			pq.remove(curr);
			visited[curr] = 1;
			for(int i[] : adjlist.get(curr)){
				if(visited[i[0]]==0){
					if(cost[i[0]]>i[1]){
						cost[i[0]] = i[1];
						parent[i[0]] = curr;
					}
					pq.add(i[0]);
				}
			}
		}
		int ret = 0;
		for(int i: parent){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : cost){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<v;++i)ret+=cost[i];
		return ret;
	}
}