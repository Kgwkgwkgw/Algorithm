
public class Cover {
//	static char[][] board = { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', },
//			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
//	static char[][] board = {
//			{ '#', '.','.','.','.','.', '#'},
//			{ '#', '.','.','.','.','.', '#'},
//			{ '#', '#','.','.','.','#', '#'}
//	};
	static char[][] board = {
	{ '#', '.','.','.','.','.', '#'},
	{ '#', '.','.','.','.','.', '#'},
	{ '#', '#','.','.','#','#', '#'}
};
	static int[][][] blockL = {
			{
				{ 0, 0, -1 },
				{ 0, 1, 1 }
			},
			{
				{ 0, 1, 0 },
				{ 0, 0, 1 }
			},
			{
				{ 0, 1, 1 },
				{ 0, 0, 1 }
			},
			{
				{ 0, 0, 1 },
				{ 0, 1, 1 }
			}
	};
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		int x=-1;
		int y=-1;
		boolean isBreak= false;
		for(int i=0; i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]=='.') {
					y=i;
					x=j;
					isBreak =true;
					break;
				}
			}
			if(isBreak)
				break;
		}
		if( x==-1 && y==-1) {
			return 1;
		}
		System.out.println(" x : " + x);
		System.out.println(" y : " + y);
		for(int i=0; i< board.length;i++) {
			System.out.println(board[i]);
		}
		int ret = 0;
		for(int i=0;i<blockL.length;i++) {
			int x1 = blockL[i][0][0] + x;
			System.out.println(" x1: " + x1);
			int x2=  blockL[i][0][1] + x;
			System.out.println(" x2: " + x2);
			int x3= blockL[i][0][2] +x;
			System.out.println(" x3: " + x3);
			int y1 = blockL[i][1][0] +y;
			System.out.println(" y1: " + y1);
			int y2=  blockL[i][1][1] +y;
			System.out.println(" y2: " + y2);
			int y3= blockL[i][1][2] + y;
			System.out.println(" y3: " + y3);
			System.out.println("-----–––---");
			if(x1 <0 || x2< 0 || x3 < 0 || x1>=board[0].length || x2 >=board[0].length || x3 >= board[0].length 
					|| y1< 0 || y2 < 0 || y3< 0 || y1>=board.length || y2 >= board.length || y3>= board.length) {
				continue;
			}
			if(board[y1][x1]!='.'  
					|| board[y2][x2] != '.' 
					|| board[y3][x3] !='.' ) {
				continue;
			}
			
			board[y1][x1]='1';
			board[y2][x2]='1';
			board[y3][x3]='1';
			ret += solve();
			board[y1][x1]='.';
			board[y2][x2]='.';
			board[y3][x3]='.';
		}
		return ret;
	}
}
