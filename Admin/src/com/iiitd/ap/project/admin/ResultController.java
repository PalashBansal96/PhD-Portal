/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.admin;

import com.iiitd.ap.project.application.PhDApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ResultController {

	@FXML
	private TableView<Application> table;

	@FXML
	private TableColumn<Object, Object> enrollNo;

	@FXML
	private TableColumn<Object, Object> name;

	@FXML
	private TableColumn<Object, Object> data;

	@FXML
	void exitApplication() {
		((Stage)table.getScene().getWindow()).close();
	}

	@FXML
	void minimizeApplication() {
		((Stage)table.getScene().getWindow()).setIconified(true);
	}

	@FXML
	void goBack() throws IOException {
		Stage primaryStage = (Stage)table.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("AdminFilter.fxml"));
		primaryStage.setScene(new Scene(root, 800,600));
		primaryStage.show();
	}

	public void populate(ArrayList<PhDApplication> applications) throws Exception {

		enrollNo.setCellValueFactory(new PropertyValueFactory<>("enrollNo"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		data.setCellValueFactory(new PropertyValueFactory<>("data"));
		ArrayList<Application> ar = new ArrayList<>();

		for (PhDApplication a : applications) {
			ar.add(new Application(a.getEnrollNo(),a.getName(),  "./database/" + a.getEnrollNo() + ".txt"));
			PrintWriter writer = new PrintWriter("./database/" + a.getEnrollNo() + ".txt");
			writer.println("Name: " + a.getName());
			writer.println("Enrollment No: " + a.getEnrollNo());
			writer.println("Address:");
			writer.println(a.getAddress());
			writer.println("Mobile No: " + a.getMobileNo());

			writer.println("PhD Stream: " + a.getPhdStream());
			writer.println("Area Preference 1: " + a.getAreaPref1());
			writer.println("Area Preference 2: " + a.getAreaPref2());
			writer.println("Area Preference 3: " + a.getAreaPref3());
			writer.println("EMail: " + a.getEmail());
			writer.println("DOB: " + a.getDob());
			writer.println("Gender: " + a.getGender());
			writer.println("Category" + a.getCategory());
			writer.println("Father Name:" + a.getFatherName());
			writer.println("Nationality: " + a.getNationality());
			writer.println("Permanent Address:");
			writer.println(a.getPermAddress());
			writer.println("PinCode: " + a.getPinCode());
			writer.println("X Board: " + a.getxBoard());
			writer.println("X Board Percent: " + a.getxBoardPercent());
			writer.println("X Board Year: " + a.getxBoardYear());
			writer.println("XII Board: " + a.getXiiBoard());
			writer.println("XII Board Percent" + a.getXiiBoardPercent());
			writer.println("XII Board Year" + a.getXiiBoardYear());
			writer.println("Graduation Degree: " + a.getGradDegree());
			writer.println("Graduation Department:" + a.getGradDepartment());
			writer.println("Graduation College:" + a.getGradCollege());
			writer.println("Graduation University:" + a.getGradUniversity());
			writer.println("Graduation City: " + a.getGradCity());
			writer.println("Graduation State: " + a.getGradState());
			writer.println("Graduation Year: " + a.getGradYear());
			writer.println("Graduation Score: " + a.getGradScore());
			if(a.getGradScore().equals("CGPA"))
				writer.println("Graduation CGPA: " + a.getGradCGPA() + "/" + a.getGradNoSub());
			else
				writer.println("Graduation Percentage" + a.getGradMarks());
			writer.println("Achievements: " + a.getAchievements());
			writer.println("Physically Disabled? " + a.getPhysicallyDisabled());
			writer.println("Defence Concession? " + a.getDefenceConcession());
			writer.println("ECE? " + a.getEce());
			writer.println("Post Graduation? " + a.getPostGrad());
			writer.println("Other Degrees? " + a.getOther());
			writer.println("GATE? " + a.getGate());

			if(a.getEce()) {
				writer.println("ECE Preference 1: " + a.getEcePref1());
				writer.println("ECE Preference 2: " + a.getEcePref2());
				writer.println("ECE Preference 3: " + a.getEcePref3());
				writer.println("ECE Preference 4: " + a.getEcePref4());
			}

			if(a.getPostGrad()) {
				writer.println("Post Graduation Year: " + a.getPostGradYear());
				writer.println("Post Graduation Degree: " + a.getPostGradDegree());
				writer.println("Post Graduation Department: " + a.getPostGradDepartment());
				writer.println("Post Graduation College: " + a.getPostGradCollege());
				writer.println("Post Graduation University: " + a.getPostGradUniversity());
				writer.println("Post Graduation City: " + a.getPostGradCity());
				writer.println("Post Graduation State: " + a.getPostGradState());
				writer.println("Post Graduation Score: " + a.getPostGradScore());
				if(a.getPostGradScore().equals("CGPA"))
					writer.println("Post Graduation CGPA: " + a.getPostGradCGPA() + "/" +  a.getPostGradNoSub());
				else
					writer.println("Post Graduation Marks: " + a.getPostGradMarks());
			}

			if(a.getOther()) {
				writer.println("Other ExamName: " + a.getOtherExamName());
				writer.println("Other Subject: " + a.getOtherSubject());
				writer.println("Other Score: " + a.getOtherScore());
				writer.println("Other Rank: " + a.getOtherRank());
				writer.println("Other Year: " + a.getOtherYear());
			}

			if(a.getGate()) {
				writer.println("GATE Marks: " + a.getGateMarks());
				writer.println("GATE Score: " + a.getGateScore());
				writer.println("GATE Rank: " + a.getGateRank());
				writer.println("GATE Year: " + a.getGateYear());
				writer.println("GATE Area: " + a.getGateArea());
			}

			writer.close();
		}
		table.setItems(FXCollections.observableArrayList(ar));
	}
}
