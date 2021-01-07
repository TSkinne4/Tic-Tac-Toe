
public class AITester {
	
	public static void main(String[] args) {
		tictactoePlayer computer = new tictactoePlayer();
		int[] move, scores = new int[3];
		final int trials = 1000;
		for(int round = 0; round <trials; round++) {
			boardHandler handler = new boardHandler(true);
			while(true) {
				while(true) {
					move = computer.makeMove(handler.getBoardState(),true);
					if(handler.updateBoard(move[0], move[1]))
						break;
				}
				if(handler.checkWin()||handler.checkFull())
					break;
				while(true) {
					move = computer.makeAlternateMove(handler.getBoardState(),false);
					if(handler.updateBoard(move[0], move[1]))
						break;
				}
				if(handler.checkWin()||handler.checkFull())
					break;
			}
			if(handler.checkWin()) {
				if(handler.getPlayerTurn())
					scores[1]++;
				else
					scores[0]++;
			}
			if(handler.checkFull()&&!handler.checkWin())
				scores[2]++;
			
		}//end of for loop
		double[] percentages = new double[3];
		for(int i = 0;i<3;i++){
			percentages[i] = (double)scores[i]/trials * 100;
		}
		System.out.println("The scores are as follows:\nAI 1 Wins: " + percentages[0] + "%\nAI 2 Wins: "
				+ percentages[1] + "%\nDraws: " + percentages[2]+"%");
	} //end of main
} //end of AITester
