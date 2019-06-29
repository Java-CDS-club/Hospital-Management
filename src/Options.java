import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;

public class Options{
	
	Label cl;
	Button a;
	Button p;
	Stage stage;
	
	public void options(){
	
		stage = new Stage();
		cl = new Label("What Would You Like To Do: ");
		//cl.setStyle("-fx-font-size:15pt; -fx-font-weight:bold; -fx-text-fill: linear-gradient(#DCDCDC,#2F4F4F); -fx-font-family: Rockwell;");
		
		a = new Button("Add A New Patient");
		a.setMinSize(200, 40);
		a.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					PatientAdd p = new PatientAdd();
					p.patientAdd();
				}
			}
		);
		p = new Button("Search By Patient's ID");
		p.setMinSize(200, 40);
		p.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					Search x = new Search();
					x.search();
				}
			}
		);
		
		VBox v1 = new VBox();
		v1.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(10,10,10,10));
		v1.setSpacing(15);
		v1.getChildren().add(cl);
		v1.getChildren().add(a);
		v1.getChildren().add(p);
		
		Scene scene = new Scene(v1, 600,300);
		scene.getStylesheets().add("optionstyling");
		stage.setScene(scene);
		stage.setTitle("Options");
		stage.show();

	}
}