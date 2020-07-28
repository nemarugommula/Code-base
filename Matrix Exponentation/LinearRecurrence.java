import java.util.*;
import java.math.*;
public class LinearRecurrence{
	public static int inf = 99999999;
	public static int mod = (int)1e9+7;
	public static int k_u = 0;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int k  = in.nextInt();
		int []values = new int[k+1];
		for(int i=0;i<k;++i)values[i+1] = in.nextInt();
		int []coeff = new int[k];
		for(int i=0;i<k;++i)coeff[i] = in.nextInt();
		int n = in.nextInt();
		k_u = k;
		int ans = solve(coeff,values,k,n);
		System.out.println(ans);
	}
	public static int solve(int []coeff,int []values,int k,int n){
		if(n==0)return 0;
		if(n<=k)return values[n];
		int [][]trans = new int[k+1][k+1];
		for(int i=1;i<=k;++i){
			for(int j=1;j<=k;++j){
				if(i<k){
					if(j==(i+1))trans[i][j] = 1;
				}else{
					trans[i][j] = coeff[k-j];
				}
			}
		}
		trans = pow(trans,n-1);
		//int [][] ans_mat = multiply(trans,values);
		int ret = 0;
		for(int j=1;j<=k;++j){
			ret+=trans[1][j]*values[j];
		}
		return ret;
	}
	public static int[][] pow(int [][]trans,int n){
		if(n==1){
			return trans;
		}
		if(n%2!=0){
			int [][]temp = pow(trans,n/2);
			return multiply(trans,multiply(temp,temp));
		}
		int [][] temp = pow(trans,n/2);
		return multiply(temp,temp);
	}
	public static int[][] multiply(int [][]a,int [][]b){
		int k = k_u;
		int [][]temp = new int[k+1][k+1];
		for(int i=1;i<=k_u;++i){
			for(int j=1;j<=k_u;++j){
				for(int x=1;x<=k_u;++x){
					temp[i][j] =(temp[i][j]+(a[i][x]*b[x][j])%mod)%mod;
				}
			}
		}
		return temp;
	}
}