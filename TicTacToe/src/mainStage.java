
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainStage extends Application{
	public static void main(String[] args) {
		Application.launch(args);	
	}
	
	@Override
	public void start(Stage stage){	
		stage.setTitle("Tic Tac Toe");
		GridPane mainBoard = new GridPane();
		
		for(int rowIndex = 0; rowIndex<3; rowIndex++)
			for(int columnIndex = 0; columnIndex <3 ; columnIndex++)
				mainBoard.add(new StackPane(), columnIndex, rowIndex); 
		
		(StackPane)mainBoard.getChildren().get(2*3+2);
		
		
		VBox root = new VBox(mainBoard);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	private class mouseHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent arg0) {
			
			
		}
	}
}


