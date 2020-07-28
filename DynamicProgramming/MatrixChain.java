//Time Complexity is O(N^3)
import java.util.*;
	
public class MatrixChain{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int [][]dp  = new int[n][n];
		for(int []i : dp)Arrays.fill(i,-1);
		int ans1 = recur(1,n-1,arr,dp);
		int ans2 = bottomUp(arr,n);
		System.out.println("recur : "+ans1);
		System.out.println("bottom up : "+ans2);
	}
	//top down
	public static int recur(int left,int right,int []arr,int [][]dp){
		if(right<=left)return 0;
		int ret = Integer.MAX_VALUE;
		if(dp[left][right]!=-1)return dp[left][right];
		for(int i=left;i<right;++i){
			int first_part = recur(left,i,arr,dp);
			int last_part = recur(i+1,right,arr,dp); 
			ret = Math.min(ret,first_part+last_part+(arr[left-1]*arr[i]*arr[right]));
		}
		return dp[left][right] = ret;
	}
	//bottom up
	public static int bottomUp(int []arr,int n){
		//we don't consider first index because it is used for dimension purpose and this appiles same for last index as well
		int [][]dp = new int[n][n];
		for(int i=1;i<n;++i)dp[i][i] = 0;
		for(int i=2;i<n;++i){
			for(int j=1;j<=(n-i);++j){
				int k = j+i-1;
				dp[j][k] = inf;
				for(int x=j;x<k;++x){
					dp[j][k] = Math.min(dp[j][k],dp[j][x]+dp[x+1][k]+arr[x]*arr[j-1]*arr[k]);
				}
			}
		}
		return dp[1][n-1];
	}
}