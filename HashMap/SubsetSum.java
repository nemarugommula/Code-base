import java.util.*;
import java.math.*;
public class SubsetSum{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int target = in.nextInt();
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		boolean flag = false;
		for(int i : arr){
			sum+=i;
			if(set.contains(sum-target)){
				flag = true;
				break;
			}
			set.add(sum);
		}
		System.out.println(flag);
	}
}

