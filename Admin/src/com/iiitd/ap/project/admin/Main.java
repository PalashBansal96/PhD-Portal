/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.admin;

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
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("AdminFilter.fxml"));//.openStream());
		primaryStage.setTitle("PhD Application Admin Panel");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}
}
