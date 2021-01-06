
public class tictactoePlayer {

	tictactoePlayer(){}
	
	public int[] makeMove(int[][] boardState) {
		int[] result = new int[2];
		double doubleRowIndex = Math.random()*3;
		int intRowIndex = (int)doubleRowIndex;
		result[0] = intRowIndex;
		
		double doubleColumnIndex = Math.random()*3;
		int intColumnIndex = (int)doubleColumnIndex;
		result[1] = intColumnIndex;
		
		return result;
	}
}
