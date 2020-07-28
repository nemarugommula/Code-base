import java.util.*;
import java.math.*;
public class MinMax{
    public static int inf = 99999999;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;++i)arr[i] = in.nextInt();
        int [][]dp = new int[n][2];
        for(int []i : dp)Arrays.fill(i,-1); 
        int ans = recur(0,arr,0,dp);
        System.out.println(" ans : "+ans);
    }
    public static int recur(int index,int []arr,int playerid,int [][]dp){
        // System.out.println(" index : "+indent()x+" playerid : "+playerid);
        if(index==arr.length)return 0;
        if(dp[index][playerid]!=-1)return dp[index][playerid];
        if(playerid==0){
            int max = 0;
            int sum = 0;
            for(int i=index;i<=(index+2)&&i<arr.length;++i){
                sum+=arr[i];
                max = Math.max(max,sum+recur(i+1,arr,1,dp));
            }
            return dp[index][playerid] = max;
        }else{
            int min = inf;
            int sum = 0;
            for(int i=index;i<=(index+2)&&i<arr.length;++i){
                sum+=arr[i];
                min = Math.min(min,recur(i+1,arr,0,dp));
            }
            return dp[index][playerid] = min;
        }
    }
}