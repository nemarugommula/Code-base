import java.util.*;
import java.math.*;
public class Variation2{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;++i)arr[i] = in.nextInt();
		int k = in.nextInt();
		int ans = subarraysWithKDistinct(arr,k);
		System.out.println(" ans : "+ans);
	}
	public static int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int ret = 0;
        int n = A.length;
        for(int i=0;i<n;++i){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(map.size()==K){
                int extra_size = 1;
                int k = i+1;
                while(k<n&&map.containsKey(A[k])){
                    ++extra_size;
                    ++k;
                }
                while(map.size()==K){
                    ret+=extra_size;
                    if(map.get(A[left])==1){
                        map.remove(A[left]);
                    }else{
                        map.put(A[left],map.get(A[left])-1);
                    }
                    ++left;
                }
            }else if(map.size()>K){
                   if(map.get(A[left])==1){
                        map.remove(A[left]);
                    }else{
                        map.put(A[left],map.get(A[left])-1);
                    }
                    ++left;
            }
        }
        return ret;
    }
}


