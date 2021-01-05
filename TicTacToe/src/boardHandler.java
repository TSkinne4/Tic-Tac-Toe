
public class boardHandler {

	int[][] boardState;
	boolean playerTurn;
	
	boardHandler(boolean playerFirst){
		boardState = new int[3][3];
		playerTurn = playerFirst;
	}
	
	public boolean updateBoard(int row, int column) {
		if(boardState[row][column]==0) {
			if(playerTurn)
				boardState[row][column] = 1;
			else
				boardState[row][column] = -1;
			return true;
		}
		else
			return false;
	}
	
	public boolean checkWin() {
		boolean result = false; //assumes that no one wins
		//check the rows
		int diagonalSum = 0;
		for(int i = 0; i<3; i++) {
			int rowSum = 0;
			int columnSum = 0;
			for(int j = 0; j<3; j++) {
				rowSum+=boardState[i][j];
				columnSum+=boardState[j][i];
			}
			if(columnSum==-3||rowSum==3)
				result = true;
			diagonalSum+=boardState[i][i];
		}
		if(diagonalSum==3||diagonalSum==-3)
			result = true;
		diagonalSum = boardState[0][2]+boardState[1][1]+boardState[2][0];
		if(diagonalSum==3||diagonalSum==-3)
			result = true;
		return result;
	}
}
