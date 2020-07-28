import java.util.*;
import java.math.*;
class DSU{
	int v;
	int []parent;
	public DSU(int v){
		this.v = v;
		parent = new int[v+1];
		for(int i=1;i<=v;++i)parent[i] = i;
	}
	public boolean add(int a,int b){
		int x = find(a);
		int y = find(b);
		if(x==y)return false;
		parent[x] = y; 
		return true;
	}
	public int find(int a){
		if(parent[a]!=a){
			return parent[a] = find(parent[a]);
		}
		return parent[a];
	}
}
public class Kruskal{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		DSU ds = new DSU(v);
		int e = in.nextInt();
		int [][]arr = new int[e][3];
		int k = 0;
		while(k<e){
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			arr[k++] = new int[]{a,b,cost};
		}
		Arrays.sort(arr,(a,b)->(a[2]-b[2]));
		int ans = 0;
		for(int i=0;i<e;++i){
			int []curr = arr[i];
			int a = curr[0];
			int b = curr[1];
			int cost = curr[2];
			if(ds.add(a,b))ans+=cost;
		}
		System.out.println(" ans : "+ans);
	}
}

