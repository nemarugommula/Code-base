//Time Complexity : O(N*C) N-> number of items and C-> capacity of items
import java.util.*;

public class Knapsack{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int capacity = in.nextInt();
		int [][]arr = new int[n][2];
		int maxprofit = 0;
		for(int i=0;i<n;++i){
			int w = in.nextInt();
			int p = in.nextInt();
			arr[i][0] = w;
			arr[i][1] = p;
			maxprofit = Math.max(maxprofit,arr[i][1]);
		}
		int [][]dp = new int[n+1][capacity+1];
		for(int  i[] : dp)Arrays.fill(i,-1);
		int ans1 = recur(0,capacity,arr,dp);
		int ans2 = bottomUp(arr,capacity,n);
		int ans3 = bottomUp2(arr,capacity,n,n*maxprofit+1);
		System.out.println("Top-down answer "+ans1);
		System.out.println("Bottom-up answer "+ans2);
		System.out.println("Bottom-up answer "+ans3);
	}
	//Top-Down Approch Time Complexity : O(N*C)
	public static int recur(int index,int capacity,int [][]arr,int [][]dp){
		int n = arr.length;
		if(index==n){
			return 0;
		}
		if(capacity<0)return Integer.MIN_VALUE;
		if(dp[index][capacity]!=-1)return dp[index][capacity];
		//excluding the element
		int ans = recur(index+1,capacity,arr,dp);
		//including the element
		if(arr[index][0]<=capacity)
			ans = Math.max(ans,arr[index][1]+recur(index+1,capacity-arr[index][0],arr,dp));
		return dp[index][capacity] = ans;
	}
	//Bottom-Up Approch Time Complexity : O(N*C)
	public static int bottomUp(int [][]arr,int capacity,int n){
		int [][]dp = new int[n+1][capacity+1];
		for(int i=1;i<=n;++i){
			for(int j=1;j<=capacity;++j){
				dp[i][j] = dp[i-1][j];
				if(arr[i-1][0]<=j)
					dp[i][j] = Math.max(dp[i][j],arr[i-1][1]+dp[i-1][j-arr[i-1][0]]);
			}
		}
		return dp[n][capacity];
	}
	//Bottom up with Time complexity O(N*(MaxProfit))
	public static int bottomUp2(int [][]arr,int capacity,int n,int maxProfitValue){
		int [][] dp = new int[n+1][maxProfitValue+1];
		for(int j=1;j<=maxProfitValue;++j){
			dp[0][j] = inf;
		}
		for(int i=1;i<=n;++i){
			for(int j=1;j<=maxProfitValue;++j){
				dp[i][j] = dp[i-1][j];
				if(arr[i-1][1]<=j)
					dp[i][j] = Math.min(dp[i][j],arr[i-1][0]+dp[i-1][j-arr[i-1][1]]);
			}
		}
		int ans = 0;
		for(int j=1;j<=maxProfitValue;++j){
			if(dp[n][j]<=capacity){
				ans = j;
			}
		}
		return ans;
	}
}

