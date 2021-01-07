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
	
	Text mainText = new Text("Good Luck!"),gameHistoryText = new Text();
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
				
			}
			
		}
		
	}
}
