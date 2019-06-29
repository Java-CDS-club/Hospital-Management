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

public class PatientSearch{
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
	TextField medicines;
	
	Stage window;
	PatientRecords patients[];
	
	public void patientSearch(PatientRecords p[], String key){
		
		patients = p;
		window = new Stage();
	
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
		medicines = new TextField();
		
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
		g.add(medicines, 3,3);
		
		BorderPane b = new BorderPane();
		b.setPadding(new Insets(10,10,50,10));
		b.setCenter(g);
		
		Scene s = new Scene(b,600,270);
		s.getStylesheets().add("patientstyling");
		window.setScene(s);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Patient Info(s)");
		window.showAndWait();
		showpatient(key);
	}
	
	public PatientRecords searchpatient(String key){
        PatientRecords p = null;
        
        for(int i = 0; i < patients.length; i++){
            if(patients[i] != null && patients[i].getId().equals(key)){ 
                p = patients[i];
            }
        }
        
        return p;
    }
    
    
    public void showpatient(String searchKey){
        PatientRecords found = searchpatient(searchKey);
        
        if(found != null){ 
            name.setText(found.getName());
            id.setText(found.getId());
            age.setText(found.getAge());
            disease.setText(found.getDisease());
            bill.setText(found.getBill());
            gender.setText(found.getGender());
            appointmentdate.setText(found.getAppointmentdate());
            medicines.setText(found.getMedicines());
        }
        
        else{
            name.setText("Record not found!");
        }
    }
	
}
