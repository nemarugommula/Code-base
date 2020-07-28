import java.util.*;
import java.math.*;
public class BitmaskingDp{
	public static int inf = 99999999;
	public static List<HashSet<Integer>> list ;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int shirts = in.nextInt();
		int persons = in.nextInt();
		list = new ArrayList<>();
		for(int i=0;i<persons;++i){
			HashSet<Integer> temp = new HashSet<>();
			int size = in.nextInt();
			for(int k=0;k<size;++k)temp.add(in.nextInt());
			list.add(temp);
		}
		int [][]dp = new int[shirts+1][(1<<persons)];
		for(int i[] : dp)Arrays.fill(i,-1);
		int ans = recur(1,shirts,0,persons,dp);
		System.out.println(" ans : "+ans);
	}
	public static int recur(int index,int shirts,int bitmask,int persons,int [][]dp){
		if(bitmask==((1<<(persons))-1))return 1;
		if(index>shirts){
			return 0;
		}
		//if(dp[index][bitmask]!=-1)return dp[index][bitmask];
		int ret = recur(index+1,shirts,bitmask,persons,dp);
		for(int i=0;i<persons;++i){
			if(hasShirt(i,index)&&((bitmask&(1<<i))==0)){
				ret+=recur(index+1,shirts,(bitmask|(1<<i)),persons,dp);
			}
		}
		return dp[index][bitmask] = ret;
	}
	public static boolean hasShirt(int person,int shirt){
		return list.get(person).contains(shirt);
	}
}