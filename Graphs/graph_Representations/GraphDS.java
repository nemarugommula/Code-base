import java.util.*;
import java.math.*;
class Graph{
	public no_of_vertices;
	//use int[] if the graph is weighted 
	ArrayList<Integer> []adjlist;
	public Graph(int v){
		this.no_of_vertices = v;
		 adjlist = new ArrayList[no_of_vertices];
		 for(int i=0;i<no_of_vertices;++i){
		 	adjlist[i] = new ArrayList<Integer>();
		 }
	}
	public void addEdgeint(int a,int b,boolean bidirectinal){
		adjlist[a].add(b);
		if(bidirectinal)adjlist[b].add(a);
	}
	public void print(){
		for(int i=0;i<v;++i){
			System.out.print("current node : "+i+" --> ");
			adjlist[i].forEach(i->System.out.print(i+" "));
			System.out.println();
		}
	}
}
public class GraphDS{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		Graph g = new Graph(v);
		int E = in.nextInt();
		while(E--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			g.addEdge(a,b,false);
			//flase if directed, true if bidirectional
		}
	}
}

