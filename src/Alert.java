import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;

public class Alert {
	
	Stage stage;
	Button b;
	Label l;
	
	public void alert(String s1, String s2){
		
		stage = new Stage();
		b = new Button("Ok");
		b.setMinSize(50, 20);
		b.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					stage.close();
				}
			}
		);
		
		stage.setTitle(s1);
		l = new Label(s2);
		
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		v.setSpacing(15);
		v.getChildren().add(l);
		v.getChildren().add(b);
		
		Scene s = new Scene(v,280,150);
		s.getStylesheets().add("alertstyling");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(s);
		stage.showAndWait();
	}
	
}
