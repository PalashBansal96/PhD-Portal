/**
 * @author Palash
 * @date 9/13/2015
 */

package com.iiitd.ap.project.applicant;

import com.iiitd.ap.project.application.EmptyValueException;
import com.iiitd.ap.project.application.InvalidValueException;
import com.iiitd.ap.project.application.PhDApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

public class Controller {

	@FXML private TextField name;
	@FXML private TextField enrollNo;
	@FXML private TextArea address;
	@FXML private TextField mobileNo;
	@FXML private ToggleGroup phdStream;
	@FXML private ComboBox<String> areaPref1 = new ComboBox<>();
	@FXML private ComboBox<String> areaPref2 = new ComboBox<>();
	@FXML private ComboBox<String> areaPref3 = new ComboBox<>();
	@FXML private TextField email;
	@FXML private DatePicker dob;
	@FXML private ToggleGroup gender;
	@FXML private ToggleGroup category;
	@FXML private ToggleGroup physicallyDisabled;
	@FXML private ToggleGroup defenceConcession;
	@FXML private TextField fatherName;
	@FXML private ComboBox<String> nationality = new ComboBox<>();
	@FXML private TextArea permAddress;
	@FXML private TextField pinCode;
	@FXML private TextField xBoard;
	@FXML private TextField xBoardPercent;
	@FXML private ComboBox<String> xBoardYear = new ComboBox<>();
	@FXML private TextField xiiBoard;
	@FXML private TextField xiiBoardPercent;
	@FXML private ComboBox<String> xiiBoardYear = new ComboBox<>();
	@FXML private TextField gradDegree;
	@FXML private TextField gradDepartment;
	@FXML private TextField gradCollege;
	@FXML private TextField gradUniversity;
	@FXML private TextField gradCity;
	@FXML private ComboBox<String> gradState = new ComboBox<>();
	@FXML private ComboBox<String> gradYear = new ComboBox<>();
	@FXML private ToggleGroup gradScore;
	@FXML private TextField gradCGPA;
	@FXML private ComboBox<String> gradNoSub = new ComboBox<>();
	@FXML private TextField gradMarks;
	@FXML private CheckBox ece;
	@FXML private ComboBox<String> ecePref1 = new ComboBox<>();
	@FXML private ComboBox<String> ecePref2 = new ComboBox<>();
	@FXML private ComboBox<String> ecePref3 = new ComboBox<>();
	@FXML private ComboBox<String> ecePref4 = new ComboBox<>();
	@FXML private CheckBox postGrad;
	@FXML private TextField postGradDegree;
	@FXML private TextField postGradDepartment;
	@FXML private TextField postGradCollege;
	@FXML private TextField postGradUniversity;
	@FXML private TextField postGradCity;
	@FXML private ComboBox<String> postGradState;
	@FXML private ComboBox<String> postGradYear = new ComboBox<>();
	@FXML private ToggleGroup postGradScore;
	@FXML private TextField postGradCGPA;
	@FXML private ComboBox<String> postGradNoSub;
	@FXML private TextField postGradMarks;
	@FXML private CheckBox other;
	@FXML private TextField otherExamName;
	@FXML private TextField otherSubject;
	@FXML private TextField otherScore;
	@FXML private TextField otherRank;
	@FXML private ComboBox<String> otherYear = new ComboBox<>();
	@FXML private CheckBox gate;
	@FXML private TextField gateArea;
	@FXML private TextField gateMarks;
	@FXML private TextField gateScore;
	@FXML private TextField gateRank;
	@FXML private ComboBox<String> gateYear = new ComboBox<>();
	@FXML private TextField achievements;
	@FXML private Button masterSubmit;
	@FXML private TabPane tabPane;

	private PhDApplication phDApplication;
	private boolean verified = false;
	private String baseEnroll = "2015000";
	private String enrollDataFile = "./database/enrollno.dat";
	private String databaseFile = "./database/applications.dat";
	private boolean initialized = false;

	@FXML void submit() {
		if(!verified)
			verifyValues();
		if(!verified)
			return;
		try {
			phDApplication.appendToFile();
		} catch (IOException e) {
			System.out.println("Database is Down, please try again after sometime");
			return;
		}
		tabPane.setDisable(true);
	}

	@FXML void verifyValues() {
		if(initApplication(phDApplication)){
			masterSubmit.setDisable(false);
			verified = true;
		}else{
			masterSubmit.setDisable(true);
			verified = false;
		}
	}

	@FXML void initialize(){
		if(initialized) return;
		phDApplication = new PhDApplication(databaseFile);
		try {
			enrollNo.setText(generateEnrollmentNo());
			enrollNo.setDisable(true);
			phDApplication.setEnrollNo(enrollNo.getText());
		} catch (Exception e) {
			System.out.println("Error generating enrollment no");
		}
		populateYear();
		populateAreaPref();
		populateNationality();
		populateState();
		populateECEPref();
		gradNoSub.getItems().addAll("4", "10");
		gradNoSub.setValue("4");
		postGradNoSub.getItems().addAll("4", "10");
		postGradNoSub.setValue("4");
		initialized = true;
	}

	private void populateAreaPref(){
		areaPref1.getItems().add("Delhi");
		areaPref2.getItems().addAll("None", "Delhi");
		areaPref3.getItems().addAll("None", "Delhi");
		areaPref2.setValue("None");
		areaPref3.setValue("None");
	}

	private void populateNationality(){
		nationality.getItems().addAll("Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian",
				"Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian",
				"Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African",
				"Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch",
				"East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese",
				"Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran",
				"Hungarian", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani",
				"Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian",
				"Malagasy", "Malawian", "Malaysian", "Maldivan", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian",
				"Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerien", "North Korean", "Northern Irish",
				"Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan",
				"Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean",
				"Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss",
				"Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian",
				"Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean");
		nationality.setValue("Indian");
	}

	private void populateYear(){
		for(Integer i = 2015; i >= 1950; i--){
			if( i <= 2013) xBoardYear.getItems().add(i.toString());
			xiiBoardYear.getItems().add(i.toString());
			gradYear.getItems().add(i.toString());
			postGradYear.getItems().add(i.toString());
			otherYear.getItems().add(i.toString());
			gateYear.getItems().add(i.toString());
		}
		xBoardYear.setValue("2013");
		xiiBoardYear.setValue("2015");
		gradYear.setValue("2015");
		postGradYear.setValue("2015");
		otherYear.setValue("2015");
		gateYear.setValue("2015");
	}

	private void populateState(){
		gradState.getItems().addAll("Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhatisgarh", "Dadra and Nagar Haveli",
				"Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh",
				"Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal",
				"Uttar Pradesh", "West Bengal", "Other");
		gradState.setValue("Delhi");
		postGradState.getItems().addAll("Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhatisgarh", "Dadra and Nagar Haveli",
				"Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh",
				"Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal",
				"Uttar Pradesh", "West Bengal", "Other");
		postGradState.setValue("Delhi");
	}

	private void populateECEPref(){
		ecePref1.getItems().addAll("Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications",
				"Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems");
		ecePref1.setValue("Advanced Signal Processing");
		ecePref2.getItems().addAll("Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications",
				"Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems");
		ecePref2.setValue("Advanced Signal Processing");
		ecePref3.getItems().addAll("Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications",
				"Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems");
		ecePref3.setValue("Advanced Signal Processing");
		ecePref4.getItems().addAll("None", "Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications",
				"Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems");
		ecePref4.setValue("None");
	}

	private String generateEnrollmentNo() throws Exception {
		//File f = new File(enrollDataFile);
		//if(!f.exists()) {
		//	Files.write(Paths.get(enrollDataFile), baseEnroll.getBytes(), StandardOpenOption.APPEND);
		//}
		Integer enrollNo = Integer.parseInt(new String(Files.readAllBytes(Paths.get(enrollDataFile))));
		Files.write(Paths.get(enrollDataFile), Integer.toString(enrollNo + 1).getBytes(), StandardOpenOption.WRITE);
		return "PhD" + (enrollNo + 1);
	}

	private boolean initApplication(PhDApplication phDApplication){
		try {
			phDApplication.setName(name.getText());
			phDApplication.setEnrollNo(enrollNo.getText());
			phDApplication.setAddress(address.getText());
			phDApplication.setMobileNo(mobileNo.getText());
			phDApplication.setPhdStream(((RadioButton) phdStream.getSelectedToggle()).getText());
			phDApplication.setAreaPref1(areaPref1.getValue());
			phDApplication.setAreaPref2(areaPref2.getValue());
			phDApplication.setAreaPref3(areaPref3.getValue());
			phDApplication.setEmail(email.getText());
			try {
				phDApplication.setDob(dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}catch (Exception e){
				System.out.println("Invalid Value: DOB");
			}
			phDApplication.setGender(((RadioButton) gender.getSelectedToggle()).getText());
			phDApplication.setCategory(((RadioButton) category.getSelectedToggle()).getText());
			phDApplication.setFatherName(fatherName.getText());
			phDApplication.setNationality(nationality.getValue());
			phDApplication.setPermAddress(permAddress.getText());
			phDApplication.setPinCode(pinCode.getText());
			phDApplication.setxBoard(xBoard.getText());
			phDApplication.setxBoardPercent(xBoardPercent.getText());
			phDApplication.setxBoardYear(xBoardYear.getValue());
			phDApplication.setXiiBoard(xiiBoard.getText());
			phDApplication.setXiiBoardYear(xiiBoardYear.getValue());
			phDApplication.setXiiBoardPercent(xiiBoardPercent.getText());
			phDApplication.setAchievements(achievements.getText());
			phDApplication.setPhysicallyDisabled(((RadioButton) physicallyDisabled.getSelectedToggle()).getText());
			phDApplication.setDefenceConcession(((RadioButton) defenceConcession.getSelectedToggle()).getText());
			phDApplication.setGradDegree(gradDegree.getText());
			phDApplication.setGradDepartment(gradDepartment.getText());
			phDApplication.setGradCollege(gradCollege.getText());
			phDApplication.setGradUniversity(gradUniversity.getText());
			phDApplication.setGradCity(gradCity.getText());
			phDApplication.setGradState(gradState.getValue());
			phDApplication.setGradYear(gradYear.getValue());
			phDApplication.setGradScore(((RadioButton) gradScore.getSelectedToggle()).getText());
			if(phDApplication.getGradScore().equals("CGPA")) {
				phDApplication.setGradCGPA(gradCGPA.getText());
				phDApplication.setGradNoSub(gradNoSub.getValue());
			}else if(phDApplication.getGradScore().equals("Marks")){
				phDApplication.setGradMarks(gradMarks.getText());
			}
			phDApplication.setEce(ece.isSelected());
			phDApplication.setPostGrad(postGrad.isSelected());
			phDApplication.setOther(other.isSelected());
			phDApplication.setGate(gate.isSelected());
			if(phDApplication.getEce()) {
				phDApplication.setEcePref1(ecePref1.getValue());
				phDApplication.setEcePref2(ecePref2.getValue());
				phDApplication.setEcePref3(ecePref3.getValue());
				phDApplication.setEcePref4(ecePref4.getValue());
			}
			if(phDApplication.getPostGrad()) {
				phDApplication.setPostGradDegree(postGradDegree.getText());
				phDApplication.setPostGradDepartment(postGradDepartment.getText());
				phDApplication.setPostGradCollege(postGradCollege.getText());
				phDApplication.setPostGradUniversity(postGradUniversity.getText());
				phDApplication.setPostGradCity(postGradCity.getText());
				phDApplication.setPostGradState(postGradState.getValue());
				phDApplication.setPostGradYear(postGradYear.getValue());
				phDApplication.setPostGradScore(((RadioButton) postGradScore.getSelectedToggle()).getText());
				if(phDApplication.getPostGradScore().equals("CGPA")) {
					phDApplication.setPostGradCGPA(postGradCGPA.getText());
					phDApplication.setPostGradNoSub(postGradNoSub.getValue());
				}else if(phDApplication.getPostGradScore().equals("Marks")){
					phDApplication.setPostGradMarks(postGradMarks.getText());
				}
			}
			if(phDApplication.getOther()) {
				phDApplication.setOtherExamName(otherExamName.getText());
				phDApplication.setOtherSubject(otherSubject.getText());
				phDApplication.setOtherScore(otherScore.getText());
				phDApplication.setOtherRank(otherRank.getText());
				phDApplication.setOtherYear(otherYear.getValue());
			}
			if(phDApplication.getGate()) {
				phDApplication.setGateArea(gateArea.getText());
				phDApplication.setGateMarks(gateMarks.getText());
				phDApplication.setGateScore(gateScore.getText());
				phDApplication.setGateRank(gateRank.getText());
				phDApplication.setGateYear(gateYear.getValue());
			}
			return true;
		} catch (EmptyValueException e) {
			System.out.println("Empty field: " + e.field);
			error.setText("Empty field: " + e.field);
			return false;
		} catch (InvalidValueException e) {
			System.out.println("Invalid Value: " + e.field);
			error.setText("Invalid Value: " + e.field);
			return false;
		}
	}

	@FXML
	private Label error;

	@FXML
	void sopUpload() throws IOException {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if(file!=null){
			File t = new File("./database/SOP" + phDApplication.getEnrollNo());
			Files.copy(file.toPath(), t.toPath());
		}
	}

	@FXML
	void cvUpload() throws IOException {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if(file!=null){
			File t = new File("./database/CV" + phDApplication.getEnrollNo());
			Files.copy(file.toPath(), t.toPath());
		}
	}
	@FXML
	void exitApplication() {
		((Stage)this.tabPane.getScene().getWindow()).close();
	}

	@FXML
	void minimizeApplication() {
		((Stage)this.tabPane.getScene().getWindow()).setIconified(true);
	}
}
