
import java.awt.Color;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainStage extends Application{
	Text mainText = new Text("Hello");
	GridPane mainBoard;
	boardHandler handler = new boardHandler(true);
	tictactoePlayer computer = new tictactoePlayer();
	public static void main(String[] args) {
		Application.launch(args);	
	}
	
	@Override
	public void start(Stage stage){	
		stage.setTitle("Tic Tac Toe");
		mainBoard = new GridPane();
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++)
				mainBoard.add(new Rectangle(150,150,javafx.scene.paint.Color.WHITE), columnIndex, rowIndex); 
		
		
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++) {
				getSquare(rowIndex,columnIndex).setStroke(javafx.scene.paint.Color.BLACK);
				getSquare(rowIndex,columnIndex).setOnMouseReleased(new MouseHandler());
			}
		VBox root = new VBox(mainText,mainBoard);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public Rectangle getSquare(int row, int column) {
		return (Rectangle)mainBoard.getChildren().get(row*3+column);
	}
	
	private class MouseHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent arg0) {
			Rectangle source = (Rectangle)arg0.getSource();
			
			int colIndex = mainBoard.getColumnIndex(source);
			int roIndex = mainBoard.getRowIndex(source);
			if(handler.updateBoard(roIndex,colIndex)) {
				source.setFill(javafx.scene.paint.Color.RED);
				while(true) {
					if(handler.checkFull())
						break;
					int[] computerMove = computer.makeMove(handler.getBoardState());
					if(handler.updateBoard(computerMove[0], computerMove[1])) {
						getSquare(computerMove[0],computerMove[1]).setFill(javafx.scene.paint.Color.BLUE);
						break;
					}
				}
			if(handler.checkWin()) {
				mainText.setText("We have a winner");
			}
			}
			else;
		}
	}
}


