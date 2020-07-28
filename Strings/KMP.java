import java.util.*;
import java.math.*;
public class KMP{
	public static int inf = 99999999;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String pattern = in.next();
		int n = str.length();
		int m = pattern.length();
		int []prefix_suffix = new int[m];
		int len = 0;
		int i= 1;
		//the value at any index indicates 
		while(i<m){
			if(pattern.charAt(len)==pattern.charAt(i)){
				++len;
				prefix_suffix[i] = len;
				++i;
			}else{
				if(len==0){
					prefix_suffix[i] = len;
					++i;
				}else{
					len = prefix_suffix[len-1];
				}
			}
		}
		int left = 0;
		int right = 0;
		List<Integer> ret = new ArrayList<>();
		while(left<n){
			if(str.charAt(left)==pattern.charAt(right)){
				++left;
				++right;
			}else{
				if(right!=0)right = prefix_suffix[right-1];
				else ++left;
			}
			if(right==m){
				ret.add(left-m);
				right = prefix_suffix[right-1]; 
			}
		}
		for(int ik: ret){
			System.out.print(ik+" ");
		}
	}
}
