
import java.util.*;
class Fiboo {
    public static int k = 2;
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int trans[][] = new int[][]{{0,0,0},{0,0,1},{0,1,1}};
        int t = in.nextInt();
        int []values = new int[]{0,0,1};
        while(t--!=0){
                int n = in.nextInt();
                if(n<=1){
                    System.out.println(n);
                    continue;
                }
                int [][]temp = pow(trans,n-1);
                int ans = 0;
                for(int i=1;i<=2;++i){
                    ans+=temp[1][i]*values[i];
                }
                int nth_term = ans;
                System.out.println(nth_term);
        } 
    }
    public static int[][] pow(int [][]a,int pow){
        if(pow==1)return a;
        int [][]temp = pow(a,pow/2);
        temp = multiply(temp,temp);
        if(pow%2!=0){
            temp = multiply(a,temp);
        }
        return temp;
    }
    public static int[][] multiply(int [][]a,int [][]b){
        int [][]temp = new int[k+1][k+1];
        for(int i=1;i<=k;++i){
            for(int j=1;j<=k;++j){
                for(int x=1;x<=k;++x){
                    temp[i][j]+=(a[i][x]*b[x][j]);
                }
            }
        }
        return temp;
    }
}
