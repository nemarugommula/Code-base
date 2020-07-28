import java.util.*;
 class Articulation_bridges{
	static List<Integer> artipoints = new ArrayList<>();
	static List<int[]> bridges = new ArrayList<>();
	static int time = 1;
	static int []lowest_time;
	static int []discover_time;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		List<List<Integer>> adjlist = new ArrayList<>();
		for(int i=0;i<=v;++i){
			adjlist.add(new ArrayList<Integer>());
		}
		lowest_time = new int[v+1];
		discover_time = new int[v+1];
		int e = in.nextInt();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			adjlist.get(a).add(b);
			adjlist.get(b).add(a);
		}
		int []visited = new int[v+1];
		dfs(1,-1,visited,adjlist);
		System.out.println("articulation points : ");
		for(int i : artipoints)System.out.print(i+" ");
		System.out.println(" bridges");
		for(int i[] : bridges){
			System.out.println(i[0]+" "+i[1]);
		}
		// use set to remove duplicate articulation points this may occur if a nodes has multiple
		//chlidren and if one child satisfies the nodes to be articulation point then we add it
		//if other children also gives the same conditin satisfied then we add it again so to avoid this
		//we have to use set and if the other child doesnot satisfies then i has backedge and it can still be 
		//connected even then parent node is removed
	}
	public static int dfs(int src,int parent,int[] visited,List<List<Integer>> adjlist){
		discover_time[src] = lowest_time[src] = time++;
		visited[src] = 1;
		int num_of_children = 0;
		for(int i : adjlist.get(src)){
			
			if(visited[i]==0){
				++num_of_children;
				int a = dfs(i,src,visited,adjlist);
				lowest_time[src] = Math.min(lowest_time[src],a);
			}else if(i!=parent){
				lowest_time[src] = Math.min(lowest_time[src],discover_time[i]);
			}
			if(lowest_time[i]>=discover_time[src]){
				if(parent!=-1)artipoints.add(src);
			}
			if(lowest_time[i]>discover_time[src]){
				bridges.add(new int[]{src,i});
			}
		}
		if(parent==-1&&num_of_children>=2){
			artipoints.add(src);
		}
		return lowest_time[src];
	}
	
} 
