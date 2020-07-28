import java.util.*;
import java.math.*;
public class SplitWise{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int []arr = new int[v];
		int e = in.nextInt();
		while(e--!=0){
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			arr[a]-=cost;
			arr[b]+=cost;
		}
		int transactions = 0;
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int i : arr)if(i!=0)map.put(i,map.getOrDefault(i,0)+1);
		while(!map.isEmpty()){
			Integer debt = map.firstKey();
			if(map.get(debt)==1){
				map.remove(debt);
			}else{
				map.put(debt,map.get(debt)-1);
			}
			Integer credit = map.lastKey();
			if(map.get(credit)==1){
				map.remove(credit);
			}else{
				map.put(debt,map.get(credit)-1);
			}
			System.out.println(" debt : "+debt+" credit : "+credit);
			if((debt+credit)!=0)map.put(debt+credit,map.getOrDefault(debt+credit,0)+1);
			++transactions;
		}
		System.out.println(" transactions : "+transactions);
	}
}

