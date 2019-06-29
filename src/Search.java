import java.io.File;
import java.util.Scanner;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;

public class Search{
	
	Label l;
	TextField t;
	Button b;
	Stage stage;
	PatientRecords patients[];
	
		
	public void search(){
				
		l = new Label("Please Enter ID: ");
		t = new TextField();
		b = new Button("Search By ID");
		b.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					action();
				}
			}
		);
		
		HBox h1 = new HBox();
		h1.setSpacing(30);
		h1.getChildren().add(l);
		h1.getChildren().add(t);
		
		HBox h2 = new HBox();
		h2.setPadding(new Insets(100,30,20,30));
		h2.setAlignment(Pos.CENTER);
		h2.getChildren().add(b);
		
		StackPane stack = new StackPane();
		stack.setPadding(new Insets(20,30,20,30));
		stack.getChildren().add(h1);
		stack.getChildren().add(h2);
		
		Scene scene = new Scene(stack, 420,150);
		scene.getStylesheets().add("searchstyling");
		stage = new Stage();
		stage.setTitle("Search");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		read();
	}
	
	public void read(){
		try{
			File file = new File("Patient Records.txt");
			Scanner input = new Scanner(file);
			patients = new PatientRecords[50];
			int i = 0;
			
			while(input.hasNextLine()){
				String a = input.nextLine();
				String b = input.nextLine();
				String c = input.nextLine();
				String d = input.nextLine();
				String e = input.nextLine();
				String f = input.nextLine();
				String g = input.nextLine();
				String h = input.nextLine();
				PatientRecords p = new  PatientRecords(a,b,c,d,e,f,g,h);
				patients[i] = p;
				i++;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void action(){
		String i = t.getText();
		stage.close();
		PatientSearch search = new PatientSearch();
		search.patientSearch(patients, i);
	}
}
