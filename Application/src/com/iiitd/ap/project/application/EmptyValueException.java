/**
 * @author Palash
 * @date 9/13/2015
 */

package com.iiitd.ap.project.application;

import java.io.IOException;

public class EmptyValueException extends IOException {
	public String field;
	public EmptyValueException(String str) {
		super(str);
		field = str;
	}
}
