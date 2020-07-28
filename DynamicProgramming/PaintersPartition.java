//Time Complexity  : O(N*N*K)
import java.util.*;
public class PaintersPartition{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i = 0;i<n;++i) arr[i] = in.nextInt();
		int k = in.nextInt();
		int [][]dp = new int[n+1][k+1];
		for(int i[] : dp)Arrays.fill(i,-1);
		int ans1 =  recur(0,k,n,arr,dp);
		System.out.println(" ans1 : "+ans1);
	} 
	public static int recur(int index,int k,int n,int []arr,int [][]dp){
		if(index==n){
			if(k==0)return 0;
			return inf;
		}
		if(k==0)return inf;
		if(dp[index][k]!=-1)return dp[index][k];
		int sum = 0;
		int ret = inf;
		for(int i=index;i<=n-k;++i){
			sum+=arr[i];
			ret = Math.min(ret,Math.max(sum,recur(i+1,k-1,n,arr,dp)));
		}
		return dp[index][k] = ret;
	}

}