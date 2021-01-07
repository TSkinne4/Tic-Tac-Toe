
public class tictactoePlayer {

	tictactoePlayer(){}
	
	public int[] makeMove(int[][] boardState, boolean first) {
int rowSum, columnSum, rowIndex = -1, columnIndex = -1, diagonalSum = 0, marker;
		
		if(first) 
			marker = 1;
		else
			marker = -1;
		
		//win test for / diagonal
		if(boardState[2][0]+boardState[1][1]+boardState[0][2]==marker*2)
			for(int i = 0, j = 2; j>-1 && i<3; j--, i++) 
				if(boardState[j][i]==0)
					return new int[] {j,i};
		
		for(int i = 0; i<3; i++) {
			rowSum = 0;
			columnSum = 0;
			diagonalSum = 0;
			for(int j = 0; j<3 ; j++) {
				rowSum+=boardState[i][j];
				columnSum+=boardState[j][i];
				diagonalSum +=boardState[j][j]; 
			}
			if(diagonalSum==marker*2)
				for(int j = 0; j<3; j++)
					if(boardState[j][j]==0)
						return new int[] {j,j};
			if(rowSum == marker*2) 
				for(int j = 0; j<3; j++)
					if(boardState[i][j]==0)
						return new int[] {i,j};
			if(columnSum == marker*2) 
				for(int j = 0; j<3; j++)
					if(boardState[j][i]==0)
						return new int[] {j,i};
			if(rowSum == -1*marker*2)
				rowIndex = i;
			if(columnSum == -1*marker*2)
				columnIndex =i;
		}
		if(boardState[2][0]+boardState[1][1]+boardState[0][2]==-1*marker*2)
			for(int i = 0, j = 2; j>-1 && i<3; j--, i++) 
				if(boardState[j][i]==0)
					return new int[] {j,i};
		
		if(diagonalSum == -1*marker*2)
			for(int i = 0; i<3; i++)
				if(boardState[i][i]==0)
					return new int[] {i,i};
		
		if(rowIndex != -1)
			for(int i = 0; i < 3; i++)
				if(boardState[rowIndex][i]==0)
					return new int[] {rowIndex,i};
		
		if(columnIndex != -1)
			for(int i = 0; i < 3; i++)
				if(boardState[i][columnIndex]==0)
					return new int[] {i,columnIndex};

		return new int[] {(int)(Math.random()*3),(int)(Math.random()*3)};
	}
	//used for testing the ai versus another
	public int[] makeAlternateMove(int[][] boardState, boolean first) {
		return new int[] {(int)(Math.random()*3),(int)(Math.random()*3)};
	}
}