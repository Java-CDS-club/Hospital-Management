
public class PatientRecords {
	String id;
    String name;
    String age;
    String disease;
    String bill;
    String gender;
    String appointmentdate;
    String medicines;
    
	public PatientRecords(String id, String name, String age, String disease, String bill, String gender, String appointmentdate, String medicines) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.bill = bill;
		this.gender = gender;
		this.appointmentdate = appointmentdate;
		this.medicines = medicines;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
    
}
