/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.admin;

import com.iiitd.ap.project.application.PhDApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AdminFilterController {

	@FXML private TextField email;
	@FXML private TextField name;
	@FXML private TextField enrollNo;
	@FXML private ComboBox<String> category = new ComboBox<>();
	@FXML private ToggleGroup gender;
	@FXML private ToggleGroup physicallyDisabled;
	@FXML private ToggleGroup DOB;
	@FXML private DatePicker DOBDate;
	@FXML private ComboBox<String> stream = new ComboBox<>();
	@FXML private ComboBox<String> gradDegree = new ComboBox<>();
	@FXML private ComboBox<String> postGradDegree = new ComboBox<>();
	@FXML private ComboBox<String> xBoard = new ComboBox<>();
	@FXML private ComboBox<String> xiiBoard = new ComboBox<>();
	@FXML private ComboBox<String> gradDepartment = new ComboBox<>();
	@FXML private ComboBox<String> postGradDepart = new ComboBox<>();
	@FXML private TextField gradUniversity;
	@FXML private TextField postGradUniversity;
	@FXML private ComboBox<String> gradState = new ComboBox<>();
	@FXML private ComboBox<String> postGradState = new ComboBox<>();
	@FXML private CheckBox xGreat;
	@FXML private CheckBox xEqual;
	@FXML private CheckBox xLess;
	@FXML private TextField xPercent;
	@FXML private CheckBox xiiGreat;
	@FXML private CheckBox xiiEqual;
	@FXML private CheckBox xiiLess;
	@FXML private TextField xiiPercent;
	@FXML private CheckBox gradGreat;
	@FXML private CheckBox gradEqual;
	@FXML private CheckBox gradLess;
	@FXML private TextField gradPercent;
	@FXML private CheckBox postGreat;
	@FXML private CheckBox postEqual;
	@FXML private CheckBox postLess;
	@FXML private TextField postPercent;
	@FXML private CheckBox gateGreat;
	@FXML private CheckBox gateEqual;
	@FXML private CheckBox gateLess;
	@FXML private TextField gateScore;
	@FXML private DatePicker dateFrom;
	@FXML private DatePicker dateUpto;

	private String databaseFile = "./database/applications.dat";
	private ArrayList<PhDApplication> applications = new ArrayList<>();

	@FXML
	void showResults() throws IOException {

		ArrayList<PhDApplication> removal = new ArrayList<>();
		if(gender.getSelectedToggle()!=null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGender().equals(((RadioButton)gender.getSelectedToggle()).getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(physicallyDisabled.getSelectedToggle()!=null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPhysicallyDisabled().equals(((RadioButton)physicallyDisabled.getSelectedToggle()).getText().equals("Yes"))){
					removal.add(phDApplication);
				}
			}
		}
		if(!email.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getEmail().equals(email.getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(!name.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getName().equals(name.getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(category.getValue()!=null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getCategory().equals(category.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(stream.getValue()!=null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPhdStream().equals(stream.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(gradDegree.getValue()!=null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGradDegree().equals(gradDegree.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(postGradDegree.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPostGradDegree().equals(postGradDegree.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(xBoard.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getxBoard().equals(xBoard.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(xiiBoard.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getXiiBoard().equals(xiiBoard.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(gradDepartment.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGradDepartment().equals(gradDepartment.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(postGradDepart.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPostGradDepartment().equals(postGradDepart.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(gradState.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGradState().equals(gradState.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(postGradState.getValue() != null){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPostGradState().equals(postGradState.getValue())){
					removal.add(phDApplication);
				}
			}
		}
		if(!enrollNo.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getEnrollNo().equals(enrollNo.getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(!gradUniversity.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGradUniversity().equals(gradUniversity.getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(!postGradUniversity.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getPostGradUniversity().equals(postGradUniversity.getText())){
					removal.add(phDApplication);
				}
			}
		}
		if(!xPercent.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				int g = phDApplication.getxBoardPercent();
				int s = Integer.parseInt(xPercent.getText());
				if(!(xGreat.isSelected()&&g>s || xEqual.isSelected()&&g==s || xLess.isSelected()&&g<s)){
					removal.add(phDApplication);
				}
			}
		}
		if(!xiiPercent.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				int g = phDApplication.getXiiBoardPercent();
				int s = Integer.parseInt(xiiPercent.getText());
				if(!(xiiGreat.isSelected()&&g>s || xiiEqual.isSelected()&&g==s || xiiLess.isSelected()&&g<s)){
					removal.add(phDApplication);
				}
			}
		}
		if(!gradPercent.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGradScore().equals("Marks")){
					removal.add(phDApplication);
					continue;
				}
				int g = phDApplication.getGradMarks();
				int s = Integer.parseInt(gradPercent.getText());
				if(!(gradGreat.isSelected()&&g>s || gradEqual.isSelected()&&g==s || gradLess.isSelected()&&g<s)){
					removal.add(phDApplication);
				}
			}
		}
		if(!postPercent.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!(phDApplication.getPostGrad() && phDApplication.getPostGradScore().equals("Marks"))){
					removal.add(phDApplication);
					continue;
				}
				int g = phDApplication.getPostGradMarks();
				int s = Integer.parseInt(postPercent.getText());
				if(!(postGreat.isSelected()&&g>s || postEqual.isSelected()&&g==s || postLess.isSelected()&&g<s)){
					removal.add(phDApplication);
				}
			}
		}
		if(!gateScore.getText().equals("")){
			for(PhDApplication phDApplication: applications){
				if(!phDApplication.getGate()){
					removal.add(phDApplication);
					continue;
				}
				int g = phDApplication.getGateScore();
				int s = Integer.parseInt(gateScore.getText());
				if(!(gateGreat.isSelected()&&g>s || gateEqual.isSelected()&&g==s || gateLess.isSelected()&&g<s)){
					removal.add(phDApplication);
				}
			}
		}
		if(DOB.getSelectedToggle()!=null){
			try {
				String t = ((RadioButton) DOB.getSelectedToggle()).getText();
				String s = DOBDate.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				for(PhDApplication phDApplication: applications) {
					String g = phDApplication.getDob();
					if (!(t.equals("Before") && g.compareTo(s)>0 || t.equals("On") && g.equals(s) || t.equals("After") && g.compareTo(s)<0)) {
						removal.add(phDApplication);
					}
				}
			}catch (Exception ignored){}
		}
		if(dateFrom.getValue()!=null){
			try {
				String s = dateFrom.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				for (PhDApplication phDApplication : applications) {
					String g = phDApplication.getDate();
					if (s.compareTo(g)>0) {
						removal.add(phDApplication);
					}
				}
			}catch (Exception ignored){}
		}
		if(dateUpto.getValue()!=null){
			try {
				String s = dateUpto.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				for (PhDApplication phDApplication : applications) {
					String g = phDApplication.getDate();
					if (s.compareTo(g)<0) {
						removal.add(phDApplication);
					}
				}
			}catch (Exception ignored){}
		}
		applications.removeAll(removal);

		Stage primaryStage = (Stage)enrollNo.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("AdminResults.fxml"));
		Parent root = fxmlLoader.load(getClass().getResource("AdminResults.fxml").openStream());

		try {
			((ResultController)fxmlLoader.getController()).populate(applications);
		} catch (Exception e) {
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root, 800,600));
		primaryStage.show();
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
		try(BufferedReader br = new BufferedReader(new FileReader(databaseFile))) {
			for(String line; (line = br.readLine()) != null; ) {
				if(line.charAt(0)==']')
					break;
				applications.add(PhDApplication.objectFromJSON(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> phdStreamList = new ArrayList<>();
		ArrayList<String> gradDegreeList = new ArrayList<>();
		ArrayList<String> postGradDegreeList = new ArrayList<>();
		ArrayList<String> xBoardList = new ArrayList<>();
		ArrayList<String> xiiBoardList = new ArrayList<>();
		ArrayList<String> gradDepartList = new ArrayList<>();
		ArrayList<String> postDepartList = new ArrayList<>();
		ArrayList<String> gradStateList = new ArrayList<>();
		ArrayList<String> postStateList = new ArrayList<>();
		ArrayList<String> categoryList = new ArrayList<>();

		for (PhDApplication phDApplication : applications){
			putIfNot(phdStreamList, phDApplication.getPhdStream());
			putIfNot(gradDegreeList, phDApplication.getGradDegree());
			putIfNot(postGradDegreeList, phDApplication.getPostGradDegree());
			putIfNot(xBoardList, phDApplication.getxBoard());
			putIfNot(xiiBoardList, phDApplication.getXiiBoard());
			putIfNot(gradDepartList, phDApplication.getGradDepartment());
			putIfNot(postDepartList, phDApplication.getPostGradDepartment());
			putIfNot(gradStateList, phDApplication.getGradState());
			putIfNot(postStateList, phDApplication.getPostGradState());
			putIfNot(categoryList, phDApplication.getCategory());
		}
		stream.getItems().addAll(phdStreamList);
		gradDegree.getItems().addAll(gradDegreeList);
		postGradDegree.getItems().addAll(postGradDegreeList);
		xBoard.getItems().addAll(xBoardList);
		xiiBoard.getItems().addAll(xiiBoardList);
		gradDepartment.getItems().addAll(gradDepartList);
		postGradDepart.getItems().addAll(postDepartList);
		gradState.getItems().addAll(gradStateList);
		postGradState.getItems().addAll(postStateList);
		category.getItems().addAll(categoryList);
	}

	private void putIfNot(ArrayList<String> a, String p){
		if(!a.contains(p))
			a.add(p);
	}
}
