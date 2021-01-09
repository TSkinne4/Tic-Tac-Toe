import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AIWatcher extends Application{
boolean gameDone = false;
	
	Text mainText = new Text(""),gameHistoryText = new Text();
	GridPane mainBoard;
	boardHandler handler = new boardHandler(true);
	tictactoePlayer computer = new tictactoePlayer();
	int[] gameHistory = new int[3];
	
	public static void main(String[] args) {
		Application.launch(args);	
	}
	
	@Override
	public void start(Stage stage){	
		stage.setTitle("Tic Tac Toe Tester");
		mainBoard = new GridPane();
	
		mainText.setFont(new Font("Times New Roman",50));
		
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++)
				mainBoard.add(new Rectangle(150,150,javafx.scene.paint.Color.WHITE), columnIndex, rowIndex); 
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++) {
				getSquare(rowIndex,columnIndex).setStroke(javafx.scene.paint.Color.BLACK);
			}
		
		Button resetButton = new Button("New Game");
		//resetButton.setOnAction(new buttonHandler());
		
		gameHistoryText.setText("AI1: "+gameHistory[0]+"  AI2: "+gameHistory[1]+"  D: "+gameHistory[2]);
		
		VBox root = new VBox(mainText,mainBoard,gameHistoryText, resetButton);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public Rectangle getSquare(int row, int column) {
		return (Rectangle)mainBoard.getChildren().get(row*3+column);
	}
	
	private class buttonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			while(!gameDone) {
				boolean run = handler.checkWin();
				while(!run) {
					int[] computerFirst = computer.makeMove(handler.getBoardState(),true);
					if(handler.updateBoard(computerFirst[0], computerFirst[1])) {
						getSquare(computerFirst[0],computerFirst[1]).setFill(javafx.scene.paint.Color.RED);
						break;
					}
					if(handler.checkFull())
						break;
					int[] computerMove = computer.makeMove(handler.getBoardState(),false);
					if(handler.updateBoard(computerMove[0], computerMove[1])) {
						getSquare(computerMove[0],computerMove[1]).setFill(javafx.scene.paint.Color.BLUE);
						break;
					}
				}
				if(handler.checkWin()) {
					if(handler.getPlayerTurn()) {
						mainText.setText("You Lose!");
						gameHistory[1]++;
					}
					else {
						mainText.setText("You Win!");
						gameHistory[0]++;
					}
					gameDone = true;
				}
				else
					if(handler.checkFull()) {
						mainText.setText("Draw!");
						gameHistory[2]++;
						gameDone = true;
					}
				
			}
		
		}
	}
}
