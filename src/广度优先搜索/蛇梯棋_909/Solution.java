package 广度优先搜索.蛇梯棋_909;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/6/27 10:54
 * @Created by Fabric
 */
class Solution {
	int result;
//	public int snakesAndLadders(int[][] board) {
//		result = Integer.MAX_VALUE;
//
//	}
	public void bfs(int[][] board,int location,int steps){
		if(location>=35) {
			result = Math.min(result,steps);
			return;
		}
		int x;
		int y;
		for (int i = 1; i < 6; i++) {
		   	int tmp = location + i;
			x = 5 - tmp/6;
			if(x%2 == 0) y = 5 -tmp%6;
			else y = tmp%6;
			if(tmp>=35){
				bfs(board,tmp,steps+1);
				return;
			}else {
			    if (board[x][y] > 0 ){
			    	tmp = board[x][y];
			    	board[x][y] = -1;
			    	bfs(board, tmp-1, steps + 1);
			    	board[x][y] = tmp;
				}else{
					bfs(board,tmp,steps+1);
				}
			}
		}
	}
}