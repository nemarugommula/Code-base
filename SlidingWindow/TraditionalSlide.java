import java.util.*;
import java.math.*;
public class TraditionalSlide{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int sum = in.nextInt();
		int ans[] = method1(arr,n,sum);
		int ans1[] = method2(arr,n,sum);
		System.out.println(" ans1 : left : "+ans[0]+" "+ans[1]);
		System.out.println(" ans2 : left : "+ans1[0]+" "+ans1[1]);
	}
	//to find smallest subsubset with sum
	public static int[] method1(int []arr,int n,int target){
		int left = 0;
		int ii = -1;
		int j = -1;
		int sum = 0;
		int ans_size = arr.length+1;
		for(int i=0;i<n;++i){
			sum+=arr[i];
			while(sum>=target&&(left<=i)){
				if(sum==target&&(i-left+1)<ans_size){
					ans_size = i-left+1;
					ii= left;
					j = i;
				}
				sum-=arr[left++];
			}
		}
		return new int[]{ii,j};
	}
	//another way to write for the same thing
	public static int[] method2(int []arr,int n,int target){
		int left = 0;
		int ii = -1;
		int j = -1;
		int sum = 0;
		int right = 0;
		int ans_size = arr.length+1;
		while(right<n){
			while(right<n&&sum<target){
				sum+=arr[right++];
			}
			while(left<=right&&sum>target){
				sum-=arr[left++];
			}
			while(left<=right&&sum==target){
				if((right-left+1)<ans_size){
					ans_size = (right-left+1);
					ii = left;
					j = right-1;
				}
				sum-=arr[left++];
			}
		}
		return new int[]{ii,j};
	}
}