/**
 * @author Palash
 * @date 9/13/2015
 */

package com.iiitd.ap.project.applicant;

import com.iiitd.ap.project.application.EmptyValueException;
import com.iiitd.ap.project.application.InvalidValueException;
import com.iiitd.ap.project.application.PhDApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {

	@FXML private TextField name;
	@FXML private TextField enrollNo;
	@FXML private TextArea address;
	@FXML private TextField mobileNo;
	@FXML private ToggleGroup phdStream;
	@FXML private ComboBox<?> areaPref1;
	@FXML private ComboBox<?> areaPref2;
	@FXML private ComboBox<?> areaPref3;
	@FXML private TextField email;
	@FXML private DatePicker dob;
	@FXML private ToggleGroup gender;
	@FXML private ToggleGroup category;
	@FXML private ToggleGroup physicallyDisabled;
	@FXML private ToggleGroup defenceConcession;
	@FXML private TextField fatherName;
	@FXML private ComboBox<?> nationality;
	@FXML private TextArea permAddress;
	@FXML private TextField pinCode;
	@FXML private TextField xBoard;
	@FXML private TextField xBoardPercent;
	@FXML private ComboBox<?> xBoardYear;
	@FXML private TextField xiiBoard;
	@FXML private TextField xiiBoardPercent;
	@FXML private ComboBox<?> xiiBoardYear;
	@FXML private TextField gradDegree;
	@FXML private TextField gradDepartment;
	@FXML private TextField gradCollege;
	@FXML private TextField gradUniversity;
	@FXML private TextField gradCity;
	@FXML private ComboBox<?> gradState;
	@FXML private ComboBox<?> gradYear;
	@FXML private ToggleGroup gradScore;
	@FXML private TextField gradCGPA;
	@FXML private ComboBox<?> gradNoSub;
	@FXML private TextField gradMarks;
	@FXML private CheckBox ece;
	@FXML private ComboBox<?> ecePref1;
	@FXML private ComboBox<?> ecePref2;
	@FXML private ComboBox<?> ecePref3;
	@FXML private ComboBox<?> ecePref4;
	@FXML private CheckBox postGrad;
	@FXML private TextField postGradDegree;
	@FXML private TextField postGradDepartment;
	@FXML private TextField postGradCollege;
	@FXML private TextField postGradUniversity;
	@FXML private TextField postGradCity;
	@FXML private ComboBox<?> postGradState;
	@FXML private ComboBox<?> postGradYear;
	@FXML private ToggleGroup postGradScore;
	@FXML private TextField postGradCGPA;
	@FXML private ComboBox<?> postGradNoSub;
	@FXML private TextField postGradMarks;
	@FXML private CheckBox other;
	@FXML private TextField otherExamName;
	@FXML private TextField otherSubject;
	@FXML private TextField otherScore;
	@FXML private TextField otherRank;
	@FXML private ComboBox<?> otherYear;
	@FXML private CheckBox gate;
	@FXML private TextField gateArea;
	@FXML private TextField gateMarks;
	@FXML private TextField gateScore;
	@FXML private TextField gateRank;
	@FXML private ComboBox<?> gateYear;
	@FXML private TextField achievements;
	@FXML private Button masterSubmit;

	private PhDApplication phDApplication;
	private boolean verified = false;

	public Controller() {
		phDApplication = new PhDApplication("./database/applications.dat");
	}

	@FXML void submit() {
		if(!verified)
			verifyValues();
		if(!verified)
			return;
		try {
			phDApplication.appendToFile();
		} catch (IOException e) {
			System.out.println("Database is Down, please try again after sometime");
		}
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

	private boolean initApplication(PhDApplication phDApplication){
		try {
			phDApplication.setName(name.getText());
			phDApplication.setEnrollNo(enrollNo.getText());
			phDApplication.setAddress(address.getText());
			phDApplication.setMobileNo(mobileNo.getText());
			phDApplication.setPhdStream(((RadioButton)phdStream.getSelectedToggle()).getText());
			phDApplication.setAreaPref1(areaPref1.getValue().toString());
			phDApplication.setAreaPref2(areaPref2.getValue().toString());
			phDApplication.setAreaPref3(areaPref3.getValue().toString());
			phDApplication.setEmail(email.getText());
			phDApplication.setDob(dob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			phDApplication.setGender(((RadioButton)gender.getSelectedToggle()).getText());
			phDApplication.setCategory(((RadioButton)category.getSelectedToggle()).getText());
			phDApplication.setFatherName(fatherName.getText());
			phDApplication.setNationality(nationality.getValue().toString());
			phDApplication.setPermAddress(permAddress.getText());
			phDApplication.setPinCode(pinCode.getText());
			phDApplication.setxBoard(xBoard.getText());
			phDApplication.setxBoardPercent(xBoardPercent.getText());
			phDApplication.setxBoardYear(xBoardYear.getValue().toString());
			phDApplication.setXiiBoard(xiiBoard.getText());
			phDApplication.setXiiBoardYear(xiiBoardYear.getValue().toString());
			phDApplication.setXiiBoardPercent(xiiBoardPercent.getText());
			phDApplication.setAchievements(achievements.getText());
			phDApplication.setPhysicallyDisabled(((RadioButton)physicallyDisabled.getSelectedToggle()).getText());
			phDApplication.setDefenceConcession(((RadioButton)defenceConcession.getSelectedToggle()).getText());
			phDApplication.setGradDegree(gradDegree.getText());
			phDApplication.setGradDepartment(gradDepartment.getText());
			phDApplication.setGradCollege(gradCollege.getText());
			phDApplication.setGradUniversity(gradUniversity.getText());
			phDApplication.setGradCity(gradCity.getText());
			phDApplication.setGradState(gradState.getValue().toString());
			phDApplication.setGradYear(gradYear.getValue().toString());
			phDApplication.setGradScore(((RadioButton) gradScore.getSelectedToggle()).getText());
			if(phDApplication.getGradScore().equals("CGPA")) {
				phDApplication.setGradCGPA(gradCGPA.getText());
				phDApplication.setGradNoSub(gradNoSub.getValue().toString());
			}else if(phDApplication.getGradScore().equals("Marks")){
				phDApplication.setGradMarks(gradMarks.getText());
			}
			phDApplication.setEce(ece.isSelected());
			phDApplication.setPostGrad(postGrad.isSelected());
			phDApplication.setOther(other.isSelected());
			phDApplication.setGate(gate.isSelected());
			if(phDApplication.getEce()) {
				phDApplication.setEcePref1(ecePref1.getValue().toString());
				phDApplication.setEcePref2(ecePref2.getValue().toString());
				phDApplication.setEcePref3(ecePref3.getValue().toString());
				phDApplication.setEcePref4(ecePref4.getValue().toString());
			}
			if(phDApplication.getPostGrad()) {
				phDApplication.setPostGradDegree(postGradDegree.getText());
				phDApplication.setPostGradDepartment(postGradDepartment.getText());
				phDApplication.setPostGradCollege(postGradCollege.getText());
				phDApplication.setPostGradUniversity(postGradUniversity.getText());
				phDApplication.setPostGradCity(postGradCity.getText());
				phDApplication.setPostGradState(postGradState.getValue().toString());
				phDApplication.setPostGradYear(postGradYear.getValue().toString());
				phDApplication.setPostGradScore(((RadioButton) postGradScore.getSelectedToggle()).getText());
				if(phDApplication.getPostGradScore().equals("CGPA")) {
					phDApplication.setPostGradCGPA(postGradCGPA.getText());
					phDApplication.setPostGradNoSub(postGradNoSub.getValue().toString());
				}else if(phDApplication.getPostGradScore().equals("Marks")){
					phDApplication.setPostGradMarks(postGradMarks.getText());
				}
			}
			if(phDApplication.getOther()) {
				phDApplication.setOtherExamName(otherExamName.getText());
				phDApplication.setOtherSubject(otherSubject.getText());
				phDApplication.setOtherScore(otherScore.getText());
				phDApplication.setOtherRank(otherRank.getText());
				phDApplication.setOtherYear(otherYear.getValue().toString());
			}
			if(phDApplication.getGate()) {
				phDApplication.setGateArea(gateArea.getText());
				phDApplication.setGateMarks(gateMarks.getText());
				phDApplication.setGateScore(gateScore.getText());
				phDApplication.setGateRank(gateRank.getText());
				phDApplication.setGateYear(gateYear.getValue().toString());
			}
			return true;
		} catch (EmptyValueException e) {
			System.out.println("Empty field: " + e.field);
			return false;
		} catch (InvalidValueException e) {
			System.out.println("Invalid Value: " + e.field);
			return false;
		}
	}
}
