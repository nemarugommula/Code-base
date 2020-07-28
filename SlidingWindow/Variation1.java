import java.util.*;
import java.math.*;
public class Variation{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();
		List<Integer> ret = new ArrayList<>();
		int len2 = str2.length();
		int []freq2 = new int[26]
		for(int i=0;i<len2;++i){
			freq2[str2.charAt(i)-'a']++;
			freq1[str1.charAt(i)-'a']++;
		}
		if(check(freq1,freq2))ret.add(0);
		for(int i=len1;i<str1.length();++i){
			char left  = str1.charAt(i-len1);
			freq1[left-'a']--;
			freq1[str1.charAt(i)-'a']++;
			if(check(freq1,freq2))ret.add(i);
		}
	}
	public static boolean check(int []a,int []b){
		for(int i=0;i<26;++i){
			if(a[i]!=b[i])return false;
		}
		return true;
	}
}

