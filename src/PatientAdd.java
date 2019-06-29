import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;
import java.util.*;
import java.io.*;

public class PatientAdd{
	Label idl;
	Label namel;
	Label agel;
	Label diseasel;
	Label billLabel;
	Label genderl;
	Label appointmentdatel;
	Label medicinel;
	
	TextField id;
	TextField name;
	TextField age;
	TextField disease;
	TextField bill;
	TextField gender;
	TextField appointmentdate;
	TextField medicine;
	
	PatientRecords patients[];
	Button add;
	Stage window;
	
	public void patientAdd(){
		
		window  = new Stage();
	
		idl = new Label("ID :");
		namel = new Label("Name :");
		agel = new Label("Age :");
		diseasel = new Label("Disease :");
		billLabel = new Label("Bill :");
		genderl = new Label("Gender :");
		appointmentdatel = new Label("Appointment Date :");
		medicinel = new Label("Medicine :");
		
		id = new TextField();
		name = new TextField();
		age = new TextField();
		disease = new TextField();
		bill = new TextField();
		gender = new TextField();
		appointmentdate = new TextField();
		medicine = new TextField();
		
		add = new Button("Add Patient");
		add.setMinHeight(30);
		add.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					action();
				}
			}
		);
		
		HBox h = new HBox();
		h.setAlignment(Pos.CENTER);
		h.getChildren().add(add);
		
		GridPane g = new GridPane();
		g.setHgap(20);
		g.setVgap(15);
		g.setPadding(new Insets(10,10,10,10));
		g.add(idl, 0,0);
		g.add(agel, 0,1);
		g.add(billLabel, 0,2);
		g.add(appointmentdatel, 0,3);
		g.add(id, 1,0);
		g.add(age, 1,1);
		g.add(bill, 1,2);
		g.add(appointmentdate, 1,3);
		g.add(namel, 2,0);
		g.add(diseasel, 2,1);
		g.add(genderl, 2,2);
		g.add(medicinel, 2,3);
		g.add(name, 3,0);
		g.add(disease, 3,1);
		g.add(gender, 3,2);
		g.add(medicine, 3,3);
		
		BorderPane b = new BorderPane();
		b.setPadding(new Insets(10,10,50,10));
		b.setCenter(g);
		b.setBottom(h);
		
		Scene scene = new Scene(b,620,270);
		scene.getStylesheets().add("patientstyling");
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Patient Info(a)");
		window.showAndWait();
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
	
	public void write(){
		try{
			File file = new File("Patient Records.txt");
			PrintWriter output = new PrintWriter(file);
			
			for(int i = 0; i < patients.length; i++){
				if(patients[i] != null){
					output.println(patients[i].getId());
					output.println(patients[i].getName());
					output.println(patients[i].getAge());
					output.println(patients[i].getDisease());
					output.println(patients[i].getBill());
					output.println(patients[i].getGender());
					output.println(patients[i].getAppointmentdate());
					output.println(patients[i].getMedicines());
					output.printf("\n\n");
				}
			}
			output.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void addpatient(PatientRecords p){
        
        int index = 0;
        
        for(int i = 0; i < patients.length; i++){
            if(patients[i] == null){
                index = i;
                break;
            }
        }
        
        if(index < patients.length){
            patients[index] = p;
        }
    }
	public void action(){
		String a = id.getText();
		String b = name.getText();
		String c = age.getText();
		String d = disease.getText();
		String e = bill.getText();
		String f = gender.getText();
		String g = appointmentdate.getText();
		String h = medicine.getText();
	
		PatientRecords p = new PatientRecords(a,b,c,d,e,f,g,h);
		addpatient(p);
		write();
		window.close();
	}
}
