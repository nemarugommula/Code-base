import java.util.*;
import java.math.*;
public class LIS{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int[]dp = new int[n];
		Arrays.fill(dp,-1);
		int ans1 = 0;
		for(int i=n-1;i>=0;--i){
			ans1 = Math.max(ans1,recur(i,arr,dp));
		}
		int ans2 = bottomUp(arr,n);
		System.out.println(" ans1 : "+ans1);
		System.out.println(" ans2 : "+ans2);
	}
	public static int recur(int index,int []arr,int []dp){
		if(index<0)return 0;
		if(dp[index]!=-1)return dp[index];
		int ret = 1;
		for(int i=index-1;i>=0;--i){
			if(arr[index]>arr[i]){
				ret = Math.max(ret,1+recur(i,arr,dp));
			}
		}
		return ret;
	}
	public static int bottomUp(int []arr,int n){
		int ret = 0;
		int []dp = new int[n];
		for(int i=0;i<n;++i){
			dp[i] = 1;
			for(int j=i-1;j>=0;--j){
				if(arr[i]>arr[j]){
					dp[i] = Math.max(dp[i],1+dp[j]);
				}
			}
			ret = Math.max(ret,dp[i]);
		}
		return ret;
	}
}