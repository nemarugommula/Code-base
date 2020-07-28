import java.util.*;
import java.math.*;
public class LongestPalindromicSubstring{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int ans = bottomUp(str);
		int ans1 = bottomup2(str);
		System.out.println(" ans : "+ans);
		System.out.println(" ans1 : "+ans1);
	}
	public static int bottomUp(String str){
		int n = str.length();
		int [][]dp = new int[n][n];
		for(int i=0;i<n;++i)dp[i][i] = 1;
		int max = 1;
		for(int i=2;i<=n;++i){
			for(int j=0;j<=(n-i);++j){
				int k = j+i-1;
				if(str.charAt(k)==str.charAt(j)&&((j+1==k)||(dp[j+1][k-1]!=0))){
					dp[j][k] = 2+dp[j+1][k-1];
				}else{
					dp[j][k] = 0;
				}
				max = Math.max(max,dp[j][k]);
			}
		}
		return max;
	}
	public static int bottomup2(String str){
		int ret = 0;
		int n = str.length();
		for(int i=0;i<n-1;++i){
			int middle = recur(str,i,i);
			int lt_rt = recur(str,i,i+1);
			ret = Math.max(ret,Math.max(middle,lt_rt));
		}
		return ret;
	}
	public static int recur(String str,int left,int right){
		int count = 0;
		while((left>=0)&&(right<str.length())&&(str.charAt(left)==str.charAt(right))){
			count+=(left==right)?1:2;
			left--;
			++right;
		}
		return count;
	}
}