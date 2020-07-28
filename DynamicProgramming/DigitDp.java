import java.util.*;
import java.math.*;
public class DigitDp{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int sum = in.nextInt();
		int [][][]dp = new int[n.length()][sum+1][2];
		for(int i[][] : dp)
			for(int k[] : i)Arrays.fill(k,-1);
		int ans = recur(0,n,n.length(),0,sum,dp);
		System.out.println(" ans : "+ans);
	}
	public static int recur(int pos,String str,int size,int flag,int sum,int [][][]dp){
		if(pos==size){
			if(sum==0)return 1;
			return 0;
		}
		if(sum<=0)return 0;
		int last = (flag==0)?str.charAt(pos)-'0':9;
		int ret = 0;
		for(int i=0;i<=last;++i){
			int temp = (flag==0&&i==last)?0:1;
			ret+=recur(pos+1,str,size,temp,sum-i,dp);
		}
		return dp[pos][sum][flag] = ret;
	}
}