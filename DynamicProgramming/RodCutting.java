//Time complexity is O(N*Size)
import java.util.*;
public class RodCutting{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int size = in.nextInt();
		int []dp1 = new int[size+1];
		Arrays.fill(dp1,-1);
		int ans1 = recur1(arr,size,dp1);
		int [][]dp2 = new int[n+1][size+1];
		for(int i[] : dp2)Arrays.fill(i,-1);
		int ans2 = recur2(0,arr,size,dp2);
		int ans3 = bottomUp(arr,size);
		System.out.println(" recur 1 : "+ans1);
		System.out.println(" recur 2 : "+ans2);
		System.out.println(" recur 3 : "+ans3);
	}
	//one way to write 
	public static int recur1(int []arr,int size,int []dp){
		if(size==0)return 0;
		if(size<0)return inf;
		if(dp[size]!=-1)return dp[size];
		int ret = inf;
		int n = arr.length;
		for(int s=0;s<n;++s){
			ret = Math.min(ret,arr[s]+recur1(arr,size-(s+1),dp));
		}
		return dp[size] = ret;
	}
	//another way to write
	public static int recur2(int index,int []arr,int size,int [][]dp){
		int n = arr.length;
		if(size==0)return 0;
		if(size<0||index==n)return inf;
		if(dp[index][size]!=-1)return dp[index][size];
		int ret = recur2(index+1,arr,size,dp);
		ret = Math.min(arr[index]+recur2(index,arr,size-(index+1),dp),ret);
		return dp[index][size] = ret;
	}
	//bottom up
	public static int bottomUp(int []arr,int size){
		int []dp = new int[size+1];
		Arrays.fill(dp,inf);
		int n = arr.length;
		dp[0] = 0;
		for(int i=1;i<=size;++i){
			for(int j=1;j<=n&&(i-j>=0);++j){
				dp[i] = Math.min(dp[i],arr[j-1]+dp[i-j]);
			}
		}
		return dp[size];
	}
}