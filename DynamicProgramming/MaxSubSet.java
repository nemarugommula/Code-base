import java.util.*;
import java.math.*;
public class MaxSubSet{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int m = in.nextInt();
		int []brr = new int[m];
		for(int i=0;i<m;++i)brr[i]= in.nextInt();
		int ret = 0 ;
		int [][]dp = new int[n+1][m+1];
		for(int i=1;i<=n;++i){
			for(int j=1;j<=m;++j){
				if(arr[i-1]==brr[j-1]){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = 0;
				}
				ret = Math.max(ret,dp[i][j]);
			}		
		}
		System.out.println(ret);
	}
}

