import java.util.*;
import java.math.*;
public class LPS{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int n = str.length();
		int [][]dp = new int[n][n];
		for(int []i : dp)Arrays.fill(i,-1);
		int ans1 = recur(0,n-1,str,dp);
		int ans2 = bottomUp(str,n);
		System.out.println(" ans1 : "+ans1);	
		System.out.println(" ans2 : "+ans2);		
	}
	public static int recur(int left,int right,String str,int [][]dp){
		if(left>right)return 0;
		if(left==right)return 1;
		if(dp[left][right]!=-1)return dp[left][right];
		int ans = 0;
		if(str.charAt(left)==str.charAt(right)){
			ans = 2+recur(left+1,right-1,str,dp);
		}else{
			ans = Math.max(recur(left+1,right,str,dp),recur(left,right-1,str,dp));
		}
		return dp[left][right] = ans;
	}
	public static int bottomUp(String str,int n){
		int [][]dp = new int[n][n];
		for(int i=0;i<n;++i)dp[i][i] = 1;
		for(int i=2;i<=n;++i){
			for(int j=0;j<=(n-i);++j){
				int temp = Math.max(dp[j+1][j+i-1],dp[j][j+i-2]);
				dp[j][j+i-1]= (str.charAt(j)==str.charAt(j+i-1))?2+dp[j+1][j+i-2]:temp;
			}
		}
		return dp[0][n-1];
	}
}