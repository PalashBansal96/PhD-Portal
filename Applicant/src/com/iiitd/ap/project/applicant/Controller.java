/**
 * @author Palash
 * @date 9/13/2015
 */

package com.iiitd.ap.project.applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class Controller {

	@FXML
	private TextField name;
	@FXML
	private TextField enrollNo;
	@FXML
	private TextArea address;
	@FXML
	private TextField mobileNo;
	@FXML
	private ToggleGroup phdStream;
	@FXML
	private ComboBox<?> areaPref1;
	@FXML
	private ComboBox<?> areaPref2;
	@FXML
	private ComboBox<?> areaPref3;
	@FXML
	private TextField email;
	@FXML
	private DatePicker dob;
	@FXML
	private ToggleGroup gender;
	@FXML
	private ToggleGroup category;
	@FXML
	private ToggleGroup physicallyDisabled;
	@FXML
	private ToggleGroup defenceConcession;
	@FXML
	private TextField fatherName;
	@FXML
	private ComboBox<?> nationality;
	@FXML
	private TextArea permAddress;
	@FXML
	private TextField pinCode;
	@FXML
	private TextField xBoard;
	@FXML
	private TextField xBoardPercent;
	@FXML
	private ComboBox<?> xBoardYear;
	@FXML
	private TextField xiiBoard;
	@FXML
	private TextField xiiBoardPercent;
	@FXML
	private ComboBox<?> xiiBoardYear;
	@FXML
	private TextField gradDegree;
	@FXML
	private TextField gradDepartment;
	@FXML
	private TextField gradCollege;
	@FXML
	private TextField gradUniversity;
	@FXML
	private TextField gradCity;
	@FXML
	private ComboBox<?> gradState;
	@FXML
	private ComboBox<?> gradYear;
	@FXML
	private ToggleGroup gradScore;
	@FXML
	private TextField gradCGPA;
	@FXML
	private ComboBox<?> gradNoSub;
	@FXML
	private TextField gradMarks;
	@FXML
	private TitledPane ece;
	@FXML
	private ComboBox<?> ecePref1;
	@FXML
	private ComboBox<?> ecePref2;
	@FXML
	private ComboBox<?> ecePref3;
	@FXML
	private ComboBox<?> ecePref4;
	@FXML
	private TitledPane postGrad;
	@FXML
	private TextField postGradDegree;
	@FXML
	private TextField postGradDepartment;
	@FXML
	private TextField postGradCollege;
	@FXML
	private TextField postGradUniversity;
	@FXML
	private TextField postGradCity;
	@FXML
	private ComboBox<?> postGradState;
	@FXML
	private ComboBox<?> postGradYear;
	@FXML
	private ToggleGroup postGradScore;
	@FXML
	private TextField postGradCGPA;
	@FXML
	private ComboBox<?> postGradNoSub;
	@FXML
	private TextField postGradMarks;
	@FXML
	private TitledPane other;
	@FXML
	private TextField otherExamName;
	@FXML
	private TextField otherSubject;
	@FXML
	private TextField otherScore;
	@FXML
	private TextField otherRank;
	@FXML
	private ComboBox<?> otherYear;
	@FXML
	private TitledPane gate;
	@FXML
	private TextField gateArea;
	@FXML
	private TextField gateMarks;
	@FXML
	private TextField gateScore;
	@FXML
	private TextField gateRank;
	@FXML
	private ComboBox<?> gateYear;
	@FXML
	private TextField achievements;
	@FXML
	private Button masterSubmit;

	@FXML
	void submit(ActionEvent event) {

	}

	private List<TextField> mandatoryText;
}
