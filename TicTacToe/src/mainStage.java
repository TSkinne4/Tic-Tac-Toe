
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.function.IntBinaryOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainStage extends Application{
	
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
		stage.setTitle("Tic Tac Toe");
		mainBoard = new GridPane();
	
		mainText.setFont(new Font("Times New Roman",50));
		
		/*try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Win History.txt"));
			gameHistory = (int[])ois.readObject();
			gameHistoryText = new Text(gameHistory.toString());
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		*/
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++)
				mainBoard.add(new Rectangle(150,150,javafx.scene.paint.Color.WHITE), columnIndex, rowIndex); 
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++) {
				getSquare(rowIndex,columnIndex).setStroke(javafx.scene.paint.Color.BLACK);
				getSquare(rowIndex,columnIndex).setOnMouseReleased(new MouseHandler());
			}
		
		Button resetButton = new Button("New Game");
		resetButton.setOnAction(new buttonHandler());
		
		gameHistoryText.setText("W: "+gameHistory[0]+"  L: "+gameHistory[1]+"  D: "+gameHistory[2]);
		
		VBox root = new VBox(mainText,mainBoard,gameHistoryText, resetButton);
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
			if(!gameDone) {
				if(handler.updateBoard(roIndex,colIndex)) {
					source.setFill(javafx.scene.paint.Color.RED);
					boolean run = handler.checkWin();
					while(!run) {
						if(handler.checkFull())
							break;
						int[] computerMove = computer.makeMove(handler.getBoardState());
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
	private class buttonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			for(Node node:mainBoard.getChildren()) {
				Rectangle rectangle = (Rectangle) node;
				rectangle.setFill(javafx.scene.paint.Color.WHITE);
			}
			handler = new boardHandler(true);
			gameDone = false;
			gameHistoryText.setText("W: "+gameHistory[0]+"  L: "+gameHistory[1]+"  D: "+gameHistory[2]);
			mainText.setText("Good Luck!");
		}
		
	}
}


