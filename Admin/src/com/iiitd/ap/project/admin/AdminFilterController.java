/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.admin;

import com.iiitd.ap.project.application.PhDApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminFilterController {

	@FXML
	private TextField email;
	@FXML
	private TextField name;
	@FXML
	private TextField enrollNo;
	@FXML
	private ComboBox<String> category = new ComboBox<String>();
	@FXML
	private ToggleGroup gender;
	@FXML
	private ToggleGroup physicallyDisabled;
	@FXML
	private ToggleGroup DOB;
	@FXML
	private DatePicker DOBDate;
	@FXML
	private ComboBox<String> stream = new ComboBox<String>();
	@FXML
	private ComboBox<String> gradDegree = new ComboBox<String>();
	@FXML
	private ComboBox<String> postGradDegree = new ComboBox<String>();
	@FXML
	private ComboBox<String> xBoard = new ComboBox<String>();
	@FXML
	private ComboBox<String> xiiBoard = new ComboBox<String>();
	@FXML
	private ComboBox<String> gradDepartment = new ComboBox<String>();
	@FXML
	private ComboBox<String> postGradDepart = new ComboBox<String>();
	@FXML
	private TextField gradUniversity;
	@FXML
	private TextField postGradUniversity;
	@FXML
	private ComboBox<String> gradState = new ComboBox<String>();
	@FXML
	private ComboBox<String> postGradState = new ComboBox<String>();
	@FXML
	private CheckBox xGreat;
	@FXML
	private CheckBox xEqual;
	@FXML
	private CheckBox xLess;
	@FXML
	private TextField xPercent;
	@FXML
	private CheckBox xiiGreat;
	@FXML
	private CheckBox xiiEqual;
	@FXML
	private CheckBox xiiLess;
	@FXML
	private TextField xiiPercent;
	@FXML
	private CheckBox gradGreat;
	@FXML
	private CheckBox gradEqual;
	@FXML
	private CheckBox gradLess;
	@FXML
	private TextField gradPercent;
	@FXML
	private CheckBox postGreat;
	@FXML
	private CheckBox postEqual;
	@FXML
	private CheckBox postLess;
	@FXML
	private TextField postPercent;
	@FXML
	private CheckBox gateGreat;
	@FXML
	private CheckBox gateEqual;
	@FXML
	private CheckBox gateLess;
	@FXML
	private TextField gateScore;
	@FXML
	private DatePicker dateFrom;
	@FXML
	private DatePicker dateUpto;

	private String databaseFile = "./database/applications.dat";
	private ArrayList<PhDApplication> applications = new ArrayList<>();

	@FXML
	void showResults() {

	}

	@FXML
	void exitApplication() {
		((Stage)enrollNo.getScene().getWindow()).close();
	}

	@FXML
	void minimizeApplication() {
		((Stage)enrollNo.getScene().getWindow()).setIconified(true);
	}

	public void initialize() {
		System.out.print("ASdas");
		try(BufferedReader br = new BufferedReader(new FileReader(databaseFile))) {
			for(String line; (line = br.readLine()) != null; ) {
				if(line.charAt(0)==']')
					break;
				applications.add(PhDApplication.objectFromJSON(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
