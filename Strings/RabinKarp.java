//String pattern matching algorithm
import java.util.*;
import java.math.*;
public class RabinKarp{
	public static int k = 467;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String pattern = in.next();
		int n = str.length();
		int m = pattern.length();
		List<Integer> ret = new ArrayList<>();
		long hash_pattern = hash(pattern,0,m-1);
		long str_hash = hash(pattern,0,m-1);
		for(int i=m;i<=n;++i){
			if(hash_pattern==str_hash){
				//match
				if(str.substring(i-m,i).equals(pattern))ret.add(i-m);
			}
			if(i==n)break;
			str_hash -=str.charAt(i-m);
			str_hash/=k;
			str_hash+=Math.pow(k,m-1)*(int)(str.charAt(i));
		}
		for(int i : ret ){
			System.out.println(i+" ");
		}
	}
	public static long hash(String s,int left,int right){
		long ret = 0;
		long pow = 1;
		for(int i=left;i<=right;++i){
			ret+=pow*(int)(s.charAt(i));
			pow*=k;
		}
		return ret;
	}
}

