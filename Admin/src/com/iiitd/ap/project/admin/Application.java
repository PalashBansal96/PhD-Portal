/**
 * @author Palash Bansal
 * @date 9/13/2015
 */

package com.iiitd.ap.project.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Application {
	private final String enrollNo;
	private final String name;
	private final Hyperlink data;
	private final File file;

	Application(String enrollNo, String name, String data) {
		this.enrollNo = enrollNo;
		this.name = name;
		file = new File(data);
		this.data = new Hyperlink("Like to Data");
		this.data.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getEnrollNo(){
		return enrollNo;
	}

	public String getName(){
		return name;
	}

	public Hyperlink getData(){
		return data;
	}


}
