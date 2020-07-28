import java.util.*;
import java.math.*;
public class Adjacent_matrix{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][]adj_mat = new int[n+1][n+1];
		int E = in.nextInt();
		for(int i=0;i<E;++i){
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			adj_mat[a][b] = cost;
			//if bidirectional then
			adj_mat[b][a] = cost;
		}
	}
}

