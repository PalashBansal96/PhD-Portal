/**
 * @author Palash
 * @date 9/13/2015
 */

package com.iiitd.ap.project.application;

import java.io.IOException;

public class InvalidValueException extends IOException {
	String field;
	public InvalidValueException(String str) {
		super(str);
		field = str;
	}
}
