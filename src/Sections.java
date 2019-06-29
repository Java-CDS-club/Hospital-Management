import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.image.*;

public class Sections extends Application implements EventHandler<ActionEvent>{
	public static void main(String args[]){
		launch(args);
	}
	
	Label wl;
	Label cl;
	Button a;
	Button p;
	Stage window;
	
	public void start(Stage stage){
		
		wl = new Label("Welcome");
	
		cl = new Label("Please Choose One: ");
		
		a = new Button("Administrator");
		a.setMinSize(120, 40);
		a.setOnAction(this);
		
		p = new Button("Patient");
		p.setMinSize(120, 40);
		p.setOnAction(this);
		
		VBox v1 = new VBox();
		v1.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(10,10,10,10));
		v1.setSpacing(15);
		v1.getChildren().add(wl);
		v1.getChildren().add(cl);
		v1.getChildren().add(a);
		v1.getChildren().add(p);
		
		StackPane stack = new StackPane();
		stack.getChildren().add(v1);
		
		window = stage;
		Scene s = new Scene(stack, 530,300);
		s.getStylesheets().add("sectionstyling");
		window.setScene(s);
		window.setTitle("Sections");
		window.show();
	}
	
	public void handle(ActionEvent event){
		if(event.getSource() == a){
			LogIn l = new LogIn();
			l.login();
			window.close();
		}
		else if(event.getSource() == p){
			Search s = new Search();
			window.close();
			s.search();
		}
	}
}