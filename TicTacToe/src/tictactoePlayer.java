
public class tictactoePlayer {

	tictactoePlayer(){}
	
	public int[] makeMove(int[][] boardState, boolean first) {
		int[] result = new int[2];
		int marker, diagonalSum = 0;
		if(first)
			marker = 1;
		else
			marker = -1;
		for(int i = 0; i<3 ; i++ ) {
			int rowSum = 0, columnSum = 0;
			for(int j = 0; j<3 ; j++) {
				rowSum+=boardState[i][j];
				columnSum+=boardState[j][i];
			}
			diagonalSum+=boardState[i][i];
			if(diagonalSum==-1*marker*2)
				for(int j = 0; j<3;j++)
					if(boardState[j][j]==0)
						return new int[]{j,j};
			if(rowSum == -1* marker *2) {
				for(int j = 0; j<3;j++) {
					if(boardState[i][j]==0)
						return new int[]{i,j};
				}
			}
			if(columnSum == -1 * marker * 2) {
				for(int j = 0; j<3;j++) {
					if(boardState[j][i]==0)
						return new int[]{j,i};
				}
			}
		}
		double doubleRowIndex = Math.random()*3;
		int intRowIndex = (int)doubleRowIndex;
		result[0] = intRowIndex;
		
		double doubleColumnIndex = Math.random()*3;
		int intColumnIndex = (int)doubleColumnIndex;
		result[1] = intColumnIndex;
		return result;
	}
	//used for testing the ai versus another
	public int[] makeAlternateMove(int[][] boardState, boolean first) {
		int[] result = new int[2];
		int marker, diagonalSum = 0;
		if(first)
			marker = 1;
		else
			marker = -1;
		for(int i = 0; i<3 ; i++ ) {
			int rowSum = 0, columnSum = 0;
			for(int j = 0; j<3 ; j++) {
				rowSum+=boardState[i][j];
				columnSum+=boardState[j][i];
			}
			diagonalSum+=boardState[i][i];
			if(diagonalSum==-1*marker*2)
				for(int j = 0; j<3;j++)
					if(boardState[j][j]==0)
						return new int[]{j,j};
			if(rowSum == -1* marker *2) {
				for(int j = 0; j<3;j++) {
					if(boardState[i][j]==0)
						return new int[]{i,j};
				}
			if(columnSum == -1 * marker * 2)
				for(int j = 0; j<3;j++) {
					if(boardState[j][i]==0)
						return new int[]{j,i};
				}
			}	
		}
		double doubleRowIndex = Math.random()*3;
		int intRowIndex = (int)doubleRowIndex;
		result[0] = intRowIndex;
		
		double doubleColumnIndex = Math.random()*3;
		int intColumnIndex = (int)doubleColumnIndex;
		result[1] = intColumnIndex;
		return result;
	}
}