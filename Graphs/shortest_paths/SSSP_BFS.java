import java.util.*;
import java.math.*;
public class SSSP_BFS{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		ArrayList<Integer> adjlist[] = new ArrayList[v];
		int e = in.nextInt();
		for(int i=0;i<v;++i)adjlist[i] = new ArrayList<Integer>();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			adjlist[a].add(b);
			adjlist[b].add(a);
		}
		int dist[] = new int[v];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()){
			int curr = q.remove();
			for(int i : adjlist[curr]){
				if(dist[i]==Integer.MAX_VALUE){
					dist[i] = dist[curr]+1;
					q.add(i);
				}
			}
		}
		System.out.println(" distances : ");
		for(int i : dist)System.out.println(i+" ");
 	}
}

