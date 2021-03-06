/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.applicant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent root = FXMLLoader.load(getClass().getResource("Applicant.fxml"));
		primaryStage.setTitle("PhD Application");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}
}
