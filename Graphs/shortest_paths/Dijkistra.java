import java.util.*;
import java.math.*;
public class Dijkistra{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		ArrayList<int[]> adjlist[] = new ArrayList[v+1];
		int e = in.nextInt();
		for(int i=0;i<=v;++i)adjlist[i] = new ArrayList<int[]>();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			adjlist[a].add(new int[]{b,cost});
			adjlist[b].add(new int[]{a,cost});
		}
		int src = in.nextInt();
		int dist[] = new int[v+1];
		Arrays.fill(dist,999999);
		dist[src] = 0;
		int []visited = new int[v+1];
		System.out.println(" adjlist : ");
		for(int i=1;i<=v;++i){
			System.out.print(i+" ->>  ");
			for(int k[] : adjlist[i])System.out.print(" "+k[0]+" "+k[1]+" ");
			System.out.println();
		}
		TreeSet<Integer> set = new TreeSet<>((a,b)->dist[a]-dist[b]);
		set.add(src);
		while(!set.isEmpty()){
			int curr = set.first();
			System.out.println(" Src "+curr);
			set.remove(curr);
			visited[curr] = 1;
			for(int i[] : adjlist[curr]){
				if(visited[i[0]]==0){
					if(dist[i[0]]>(	dist[curr]+i[1])){
						dist[i[0]] = dist[curr]+i[1];
					}
					set.add(i[0]);
				}
			}
		}
		for(int i : dist){
			System.out.print(i+" ");
		}
 	}
}

