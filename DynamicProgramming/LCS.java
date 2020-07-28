import java.util.*;
import java.math.*;
public class LCS{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr1 = new int[n];
		for(int i=0;i<n;++i)arr1[i] = in.nextInt();
		int m = in.nextInt();
		int []arr2 = new int[m];
		for(int j=0;j<m;++j)arr2[j] = arr2[j] = in.nextInt();
		int [][]dp = new int[n][m];
		for(int []i : dp)Arrays.fill(i,-1);
		int ans1 = recur(n-1,m-1,arr1,arr2,dp);
		int ans2 = bottomUp(arr1,arr2);
		System.out.println("ans1 : "+ans1);
		System.out.println("ans2 : "+ans2);
	}
	public static int recur(int n,int m,int []arr1,int []arr2,int [][]dp){
		if(n<0||m<0)return 0;
		if(dp[n][m]!=-1)return dp[n][m];
		if(arr1[n]==arr2[m]){
			return dp[n][m] = 1+recur(n-1,m-1,arr1,arr2,dp);
		}
		return dp[n][m] = Math.max(recur(n-1,m,arr1,arr2,dp),recur(n,m-1,arr1,arr2,dp));
	}	
	public static int bottomUp(int []arr1,int[]arr2){
		int n = arr1.length;
		int m = arr2.length;
		int [][]dp = new int[n+1][m+1];
		for(int i=1;i<=n;++i){
			for(int j=1;j<=m;++j){
				if(arr1[i-1]==arr2[j-1]){
					dp[i][j] = 1+dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
}