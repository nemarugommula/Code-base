import java.util.*;
import java.math.*;
public class Sudoku{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		char [][]arr = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}};
		isValidSudoku(arr);
	}
	  public static  boolean isValidSudoku(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)return false;
        int n = board.length;
        int m = board[0].length;
        return helper(0,0,board,n,m);
    }
    public static boolean helper(int row,int col,char [][]board,int n,int m){
        for(char []temp : board){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("-------------------------------------------------");
        if(row==0&&col==m)return true;
        if(board[row][col]!='.'){
            if(row==n-1)col+=1;
            return helper((row+1)%n,col,board,n,m);
        }
        for(char i='1';i<='9';++i){
            if(isSafe(row,col,i,board)){
                board[row][col] = i;
                int temp_col = col;
                if(row==n-1)temp_col+=1;
                if(helper((row+1)%n,temp_col,board,n,m))return true;
                board[row][col] = '.';	
            }
        }
        return false;
    }
    public static boolean isSafe(int row,int col,char ele,char [][]board){
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;++i){
            if(board[i][col]!='.'&&(board[i][col]<='0'||board[i][col]>'9'||board[i][col]==ele))return false;
        }
        for(int i=0;i<m;++i){
            if(board[row][i]!='.'&&board[row][i]<='0'||board[row][i]>'9'||board[row][i]==ele)return false;
        }
        int box_start_x = (row/3);
        int box_start_y = (col/3);
        for(int i=box_start_x*3;i<(box_start_x*3+3);++i){
            for(int j=box_start_y*3;j<(box_start_y*3+3);++j){
                if(board[i][col]!='.'&&(board[i][col]<='0'||board[i][col]>'9'||board[i][col]==ele))return false;
            }
        }
        return true;
    }
}

