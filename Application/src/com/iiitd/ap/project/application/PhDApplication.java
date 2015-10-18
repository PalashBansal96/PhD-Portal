/**
 * @author Palash
 * @date 9/13/2015
 */
package com.iiitd.ap.project.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PhDApplication {

	private String filePath;
	private String jsonData;
	private String date;
	private String timestamp;

	public PhDApplication(String filePath) {
		this.filePath = filePath;
	}
	public PhDApplication(){}

	public static PhDApplication objectFromJSON(String json){
		PhDApplication result = new PhDApplication();
		JSONParser parser = new JSONParser();

		try{
			JSONObject jsonObject= (JSONObject) parser.parse(json);

			result.timestamp = (String) jsonObject.get("timestamp");
			result.date = (String) jsonObject.get("date");

			result.name = (String) jsonObject.get("name");
			result.enrollNo = (String) jsonObject.get("enrollNo");
			result.address = (String) jsonObject.get("address");
			result.mobileNo = (String) jsonObject.get("mobileNo");
			result.phdStream = (String) jsonObject.get("phdStream");
			result.areaPref1 = (String) jsonObject.get("areaPref1");
			result.areaPref2 = (String) jsonObject.get("areaPref2");
			result.areaPref3 = (String) jsonObject.get("areaPref3");
			result.email = (String) jsonObject.get("email");
			result.dob = (String) jsonObject.get("dob");
			result.gender = (String) jsonObject.get("gender");
			result.category = (String) jsonObject.get("category");
			result.fatherName = (String) jsonObject.get("fatherName");
			result.nationality = (String) jsonObject.get("nationality");
			result.permAddress = (String) jsonObject.get("permAddress");
			result.pinCode = (String) jsonObject.get("pinCode");
			result.xBoard = (String) jsonObject.get("xBoard");
			result.xiiBoard = (String) jsonObject.get("xiiBoard");
			result.gradDegree = (String) jsonObject.get("gradDegree");
			result.gradDepartment = (String) jsonObject.get("gradDepartment");
			result.gradCollege = (String) jsonObject.get("gradCollege");
			result.gradUniversity = (String) jsonObject.get("gradUniversity");
			result.gradCity = (String) jsonObject.get("gradCity");
			result.gradState = (String) jsonObject.get("gradState");
			result.gradScore = (String) jsonObject.get("gradScore");
			result.achievements = (String) jsonObject.get("achievements");

			result.physicallyDisabled = (Boolean) jsonObject.get("physicallyDisabled");
			result.defenceConcession = (Boolean) jsonObject.get("defenceConcession");
			result.xBoardPercent = ((Long) jsonObject.get("xBoardPercent")).intValue();
			result.xBoardYear = ((Long) jsonObject.get("xBoardYear")).intValue();
			result.xiiBoardPercent = ((Long) jsonObject.get("xiiBoardPercent")).intValue();
			result.xiiBoardYear = ((Long) jsonObject.get("xiiBoardYear")).intValue();
			result.gradYear = ((Long) jsonObject.get("gradYear")).intValue();
			if(result.gradScore.equals("CGPA")) {
				result.gradCGPA = ((Long) jsonObject.get("gradCGPA")).intValue();
				result.gradNoSub = ((Long) jsonObject.get("gradNoSub")).intValue();
			}else
				result.gradMarks = ((Long) jsonObject.get("gradMarks")).intValue();
			result.ece = (Boolean) jsonObject.get("ece");
			result.postGrad = (Boolean) jsonObject.get("postGrad");
			result.other = (Boolean) jsonObject.get("other");
			result.gate = (Boolean) jsonObject.get("gate");

			if(result.ece) {
				result.ecePref1 = (String) jsonObject.get("ecePref1");
				result.ecePref2 = (String) jsonObject.get("ecePref2");
				result.ecePref3 = (String) jsonObject.get("ecePref3");
				result.ecePref4 = (String) jsonObject.get("ecePref4");
			}

			if(result.postGrad) {
				result.postGradYear = ( (Long) jsonObject.get("postGradYear")).intValue();
				result.postGradDegree = (String) jsonObject.get("postGradDegree");
				result.postGradDepartment = (String) jsonObject.get("postGradDepartment");
				result.postGradCollege = (String) jsonObject.get("postGradCollege");
				result.postGradUniversity = (String) jsonObject.get("postGradUniversity");
				result.postGradCity = (String) jsonObject.get("postGradCity");
				result.postGradState = (String) jsonObject.get("postGradState");
				result.postGradScore = (String) jsonObject.get("postGradScore");
				if(result.postGradScore.equals("CGPA")) {
					result.postGradCGPA = ((Long) jsonObject.get("postGradCGPA")).intValue();
					result.postGradNoSub = ((Long) jsonObject.get("postGradNoSub")).intValue();
				}else
					result.postGradMarks = ( (Long) jsonObject.get("postGradMarks")).intValue();
			}

			if(result.other) {
				result.otherExamName = (String) jsonObject.get("otherExamName");
				result.otherSubject = (String) jsonObject.get("otherSubject");
				result.otherScore = ((Long) jsonObject.get("otherScore")).intValue();
				result.otherRank = ( (Long) jsonObject.get("otherRank")).intValue();
				result.otherYear = ( (Long) jsonObject.get("otherYear")).intValue();
			}

			if(result.gate) {
				result.gateMarks = ( (Long) jsonObject.get("gateMarks")).intValue();
				result.gateScore = ( (Long) jsonObject.get("gateScore")).intValue();
				result.gateRank = ( (Long) jsonObject.get("gateRank")).intValue();
				result.gateYear = ( (Long) jsonObject.get("gateYear")).intValue();
				result.gateArea = (String) jsonObject.get("gateArea");
			}

		}catch(Exception pe){
			pe.printStackTrace();
		}

		return result;
	}

	public void appendToFile() throws IOException {

		JSONObject jsonObject = new JSONObject();

		date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		timestamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());

		jsonObject.put("timestamp", timestamp);
		jsonObject.put("date", date);

		jsonObject.put("name", name);
		jsonObject.put("enrollNo", enrollNo);
		jsonObject.put("address", address);
		jsonObject.put("mobileNo", mobileNo);
		jsonObject.put("phdStream", phdStream);
		jsonObject.put("areaPref1", areaPref1);
		jsonObject.put("areaPref2", areaPref2);
		jsonObject.put("areaPref3", areaPref3);
		jsonObject.put("email", email);
		jsonObject.put("dob", dob);
		jsonObject.put("gender", gender);
		jsonObject.put("category", category);
		jsonObject.put("fatherName", fatherName);
		jsonObject.put("nationality", nationality);
		jsonObject.put("permAddress", permAddress);
		jsonObject.put("pinCode", pinCode);
		jsonObject.put("xBoard", xBoard);
		jsonObject.put("xiiBoard", xiiBoard);
		jsonObject.put("gradDegree", gradDegree);
		jsonObject.put("gradDepartment", gradDepartment);
		jsonObject.put("gradCollege", gradCollege);
		jsonObject.put("gradUniversity", gradUniversity);
		jsonObject.put("gradCity", gradCity);
		jsonObject.put("gradState", gradState);
		jsonObject.put("gradScore", gradScore);
		jsonObject.put("achievements", achievements);

		jsonObject.put("physicallyDisabled", physicallyDisabled);
		jsonObject.put("defenceConcession", defenceConcession);
		jsonObject.put("xBoardPercent", xBoardPercent);
		jsonObject.put("xBoardYear", xBoardYear);
		jsonObject.put("xiiBoardPercent", xiiBoardPercent);
		jsonObject.put("xiiBoardYear", xiiBoardYear);
		jsonObject.put("gradYear", gradYear);
		jsonObject.put("gradCGPA", gradCGPA);
		jsonObject.put("gradNoSub", gradNoSub);
		jsonObject.put("gradMarks", gradMarks);
		jsonObject.put("ece", ece);
		jsonObject.put("postGrad", postGrad);
		jsonObject.put("other", other);
		jsonObject.put("gate", gate);

		if(ece) {
			jsonObject.put("ecePref1", ecePref1);
			jsonObject.put("ecePref2", ecePref2);
			jsonObject.put("ecePref3", ecePref3);
			jsonObject.put("ecePref4", ecePref4);
		}

		if(postGrad) {
			jsonObject.put("postGradYear", postGradYear);
			jsonObject.put("postGradCGPA", postGradCGPA);
			jsonObject.put("postGradNoSub", postGradNoSub);
			jsonObject.put("postGradMarks", postGradMarks);
			jsonObject.put("postGradDegree", postGradDegree);
			jsonObject.put("postGradDepartment", postGradDepartment);
			jsonObject.put("postGradCollege", postGradCollege);
			jsonObject.put("postGradUniversity", postGradUniversity);
			jsonObject.put("postGradCity", postGradCity);
			jsonObject.put("postGradState", postGradState);
			jsonObject.put("postGradScore", postGradScore);
		}

		if(other) {
			jsonObject.put("otherExamName", otherExamName);
			jsonObject.put("otherSubject", otherSubject);
			jsonObject.put("otherScore", otherScore);
			jsonObject.put("otherRank", otherRank);
			jsonObject.put("otherYear", otherYear);
		}

		if(gate) {
			jsonObject.put("gateMarks", gateMarks);
			jsonObject.put("gateScore", gateScore);
			jsonObject.put("gateRank", gateRank);
			jsonObject.put("gateYear", gateYear);
			jsonObject.put("gateArea", gateArea);
		}

		jsonData = jsonObject.toJSONString() + "\n";

		Files.write(Paths.get(filePath), jsonData.getBytes(), StandardOpenOption.APPEND);
	}

	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws EmptyValueException {
		if (name.equals(""))
			throw new EmptyValueException("name");
		else
			this.name = name;
	}
	public String getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(String enrollNo) throws EmptyValueException {
		if (enrollNo.equals(""))
			throw new EmptyValueException("enrollNo");
		else
			this.enrollNo = enrollNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) throws EmptyValueException {
		if (mobileNo.equals(""))
			throw new EmptyValueException("mobileNo");
		else
			this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) throws EmptyValueException {
		if (address.equals(""))
			throw new EmptyValueException("address");
		else
			this.address = address;
	}
	public String getPhdStream() {
		return phdStream;
	}
	public void setPhdStream(String phdStream) throws EmptyValueException {
		if (phdStream.equals(""))
			throw new EmptyValueException("phdStream");
		else
			this.phdStream = phdStream;
	}
	public String getAreaPref1() {
		return areaPref1;
	}
	public void setAreaPref1(String areaPref1) throws EmptyValueException {
		if (areaPref1.equals(""))
			throw new EmptyValueException("areaPref1");
		else
			this.areaPref1 = areaPref1;
	}
	public String getAreaPref2() {
		return areaPref2;
	}
	public void setAreaPref2(String areaPref2) throws EmptyValueException {
		if (areaPref2.equals(""))
			throw new EmptyValueException("areaPref2");
		else
			this.areaPref2 = areaPref2;
	}
	public String getAreaPref3() {
		return areaPref3;
	}
	public void setAreaPref3(String areaPref3) throws EmptyValueException {
		if (areaPref3.equals(""))
			throw new EmptyValueException("areaPref3");
		else
			this.areaPref3 = areaPref3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmptyValueException {
		if (email.equals(""))
			throw new EmptyValueException("email");
		else
			this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) throws EmptyValueException {
		if (gender.equals(""))
			throw new EmptyValueException("gender");
		else
			this.gender = gender;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) throws EmptyValueException {
		if (category.equals(""))
			throw new EmptyValueException("category");
		else
			this.category = category;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) throws EmptyValueException {
		if (fatherName.equals(""))
			throw new EmptyValueException("fatherName");
		else
			this.fatherName = fatherName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) throws EmptyValueException {
		if (nationality.equals(""))
			throw new EmptyValueException("nationality");
		else
			this.nationality = nationality;
	}
	public String getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(String permAddress) throws EmptyValueException {
		if (permAddress.equals(""))
			throw new EmptyValueException("permAddress");
		else
			this.permAddress = permAddress;
	}
	public String getxBoard() {
		return xBoard;
	}
	public void setxBoard(String xBoard) throws EmptyValueException {
		if (xBoard.equals(""))
			throw new EmptyValueException("xBoard");
		else
			this.xBoard = xBoard;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) throws EmptyValueException {
		if (pinCode.equals(""))
			throw new EmptyValueException("pinCode");
		else
			this.pinCode = pinCode;
	}
	public String getXiiBoard() {
		return xiiBoard;
	}
	public void setXiiBoard(String xiiBoard) throws EmptyValueException {
		if (xiiBoard.equals(""))
			throw new EmptyValueException("xiiBoard");
		else
			this.xiiBoard = xiiBoard;
	}
	public String getGradDegree() {
		return gradDegree;
	}
	public void setGradDegree(String gradDegree) throws EmptyValueException {
		if (gradDegree.equals(""))
			throw new EmptyValueException("gradDegree");
		else
			this.gradDegree = gradDegree;
	}
	public String getGradDepartment() {
		return gradDepartment;
	}
	public void setGradDepartment(String gradDepartment) throws EmptyValueException {
		if (gradDepartment.equals(""))
			throw new EmptyValueException("gradDepartment");
		else
			this.gradDepartment = gradDepartment;
	}
	public String getGradCollege() {
		return gradCollege;
	}
	public void setGradCollege(String gradCollege) throws EmptyValueException {
		if (gradCollege.equals(""))
			throw new EmptyValueException("gradCollege");
		else
			this.gradCollege = gradCollege;
	}
	public String getGradUniversity() {
		return gradUniversity;
	}
	public void setGradUniversity(String gradUniversity) throws EmptyValueException {
		if (gradUniversity.equals(""))
			throw new EmptyValueException("gradUniversity");
		else
			this.gradUniversity = gradUniversity;
	}
	public String getGradCity() {
		return gradCity;
	}
	public void setGradCity(String gradCity) throws EmptyValueException {
		if (gradCity.equals(""))
			throw new EmptyValueException("gradCity");
		else
			this.gradCity = gradCity;
	}
	public String getGradState() {
		return gradState;
	}
	public void setGradState(String gradState) throws EmptyValueException {
		if (gradState.equals(""))
			throw new EmptyValueException("gradState");
		else
			this.gradState = gradState;
	}
	public String getGradScore() {
		return gradScore;
	}
	public void setGradScore(String gradScore) throws EmptyValueException {
		if (gradScore.equals(""))
			throw new EmptyValueException("gradScore");
		else
			this.gradScore = gradScore;
	}
	public String getAchievements() {
		return achievements;
	}
	public void setAchievements(String achievements) throws EmptyValueException {
		if (achievements.equals(""))
			throw new EmptyValueException("achievements");
		else
			this.achievements = achievements;
	}

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) throws EmptyValueException {
		if (dob.equals(""))
			throw new EmptyValueException("dob");
		else
			this.dob = dob;
	}
	public String getEcePref1() {
		return ecePref1;
	}
	public void setEcePref1(String ecePref1) throws EmptyValueException {
		if (ecePref1.equals(""))
			throw new EmptyValueException("ecePref1");
		else
			this.ecePref1 = ecePref1;
	}
	public String getEcePref2() {
		return ecePref2;
	}
	public void setEcePref2(String ecePref2) throws EmptyValueException {
		if (ecePref2.equals(""))
			throw new EmptyValueException("ecePref2");
		else
			this.ecePref2 = ecePref2;
	}
	public String getEcePref3() {
		return ecePref3;
	}
	public void setEcePref3(String ecePref3) throws EmptyValueException {
		if (ecePref3.equals(""))
			throw new EmptyValueException("ecePref3");
		else
			this.ecePref3 = ecePref3;
	}
	public String getEcePref4() {
		return ecePref4;
	}
	public void setEcePref4(String ecePref4) throws EmptyValueException {
		if (ecePref4.equals(""))
			throw new EmptyValueException("ecePref4");
		else
			this.ecePref4 = ecePref4;
	}
	public String getPostGradDegree() {
		return postGradDegree;
	}
	public void setPostGradDegree(String postGradDegree) throws EmptyValueException {
		if (postGradDegree.equals(""))
			throw new EmptyValueException("postGradDegree");
		else
			this.postGradDegree = postGradDegree;
	}
	public String getPostGradDepartment() {
		return postGradDepartment;
	}
	public void setPostGradDepartment(String postGradDepartment) throws EmptyValueException {
		if (postGradDepartment.equals(""))
			throw new EmptyValueException("postGradDepartment");
		else
			this.postGradDepartment = postGradDepartment;
	}
	public String getPostGradCollege() {
		return postGradCollege;
	}
	public void setPostGradCollege(String postGradCollege) throws EmptyValueException {
		if (postGradCollege.equals(""))
			throw new EmptyValueException("postGradCollege");
		else
			this.postGradCollege = postGradCollege;
	}
	public String getPostGradUniversity() {
		return postGradUniversity;
	}
	public void setPostGradUniversity(String postGradUniversity) throws EmptyValueException {
		if (postGradUniversity.equals(""))
			throw new EmptyValueException("postGradUniversity");
		else
			this.postGradUniversity = postGradUniversity;
	}
	public String getPostGradCity() {
		return postGradCity;
	}
	public void setPostGradCity(String postGradCity) throws EmptyValueException {
		if (postGradCity.equals(""))
			throw new EmptyValueException("postGradCity");
		else
			this.postGradCity = postGradCity;
	}
	public String getPostGradState() {
		return postGradState;
	}
	public void setPostGradState(String postGradState) throws EmptyValueException {
		if (postGradState.equals(""))
			throw new EmptyValueException("postGradState");
		else
			this.postGradState = postGradState;
	}
	public String getPostGradScore() {
		return postGradScore;
	}
	public void setPostGradScore(String postGradScore) throws EmptyValueException {
		if (postGradScore.equals(""))
			throw new EmptyValueException("postGradScore");
		else
			this.postGradScore = postGradScore;
	}
	public String getOtherExamName() {
		return otherExamName;
	}
	public void setOtherExamName(String otherExamName) throws EmptyValueException {
		if (otherExamName.equals(""))
			throw new EmptyValueException("otherExamName");
		else
			this.otherExamName = otherExamName;
	}
	public String getOtherSubject() {
		return otherSubject;
	}
	public void setOtherSubject(String otherSubject) throws EmptyValueException {
		if (otherSubject.equals(""))
			throw new EmptyValueException("otherSubject");
		else
			this.otherSubject = otherSubject;
	}
	public String getGateArea() {
		return gateArea;
	}
	public void setGateArea(String gateArea) throws EmptyValueException {
		if (gateArea.equals(""))
			throw new EmptyValueException("gateArea");
		else
			this.gateArea = gateArea;
	}
	public Integer getxBoardPercent() {
		return xBoardPercent;
	}
	public void setxBoardPercent(String xBoardPercent) throws EmptyValueException, InvalidValueException {
		if (xBoardPercent.equals(""))
			throw new EmptyValueException("xBoardPercent");
		else
			try {
				this.xBoardPercent = Integer.parseInt(xBoardPercent);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("xBoardPercent");
			}
	}
	public Integer getxBoardYear() {
		return xBoardYear;
	}
	public void setxBoardYear(String xBoardYear) throws EmptyValueException, InvalidValueException {
		if (xBoardYear.equals(""))
			throw new EmptyValueException("xBoardYear");
		else
			try {
				this.xBoardYear = Integer.parseInt(xBoardYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("xBoardYear");
			}
	}
	public Integer getXiiBoardPercent() {
		return xiiBoardPercent;
	}
	public void setXiiBoardPercent(String xiiBoardPercent) throws EmptyValueException, InvalidValueException {
		if (xiiBoardPercent.equals(""))
			throw new EmptyValueException("xiiBoardPercent");
		else
			try {
				this.xiiBoardPercent = Integer.parseInt(xiiBoardPercent);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("xiiBoardPercent");
			}
	}
	public Integer getXiiBoardYear() {
		return xiiBoardYear;
	}
	public void setXiiBoardYear(String xiiBoardYear) throws EmptyValueException, InvalidValueException {
		if (xiiBoardYear.equals(""))
			throw new EmptyValueException("xiiBoardYear");
		else
			try {
				this.xiiBoardYear = Integer.parseInt(xiiBoardYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("xiiBoardYear");
			}
	}
	public Integer getGradYear() {
		return gradYear;
	}
	public void setGradYear(String gradYear) throws EmptyValueException, InvalidValueException {
		if (gradYear.equals(""))
			throw new EmptyValueException("gradYear");
		else
			try {
				this.gradYear = Integer.parseInt(gradYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gradYear");
			}
	}
	public Integer getGradNoSub() {
		return gradNoSub;
	}
	public void setGradNoSub(String gradNoSub) throws EmptyValueException, InvalidValueException {
		if (gradNoSub.equals(""))
			throw new EmptyValueException("gradNoSub");
		else
			try {
				this.gradNoSub = Integer.parseInt(gradNoSub);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gradNoSub");
			}
	}
	public Integer getGradCGPA() {
		return gradCGPA;
	}
	public void setGradCGPA(String gradCGPA) throws EmptyValueException, InvalidValueException {
		if (gradCGPA.equals(""))
			throw new EmptyValueException("gradCGPA");
		else
			try {
				this.gradCGPA = Integer.parseInt(gradCGPA);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gradCGPA");
			}
	}
	public Integer getGradMarks() {
		return gradMarks;
	}
	public void setGradMarks(String gradMarks) throws EmptyValueException, InvalidValueException {
		if (gradMarks.equals(""))
			throw new EmptyValueException("gradMarks");
		else
			try {
				this.gradMarks = Integer.parseInt(gradMarks);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gradMarks");
			}
	}
	public Integer getPostGradYear() {
		return postGradYear;
	}
	public void setPostGradYear(String postGradYear) throws EmptyValueException, InvalidValueException {
		if (postGradYear.equals(""))
			throw new EmptyValueException("postGradYear");
		else
			try {
				this.postGradYear = Integer.parseInt(postGradYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("postGradYear");
			}
	}
	public Integer getPostGradCGPA() {
		return postGradCGPA;
	}

	public void setPostGradCGPA(String postGradCGPA) throws EmptyValueException, InvalidValueException {
		if (postGradCGPA.equals(""))
			throw new EmptyValueException("postGradCGPA");
		else
			try {
				this.postGradCGPA = Integer.parseInt(postGradCGPA);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("postGradCGPA");
			}
	}
	public Integer getPostGradNoSub() {
		return postGradNoSub;
	}

	public void setPostGradNoSub(String postGradNoSub) throws EmptyValueException, InvalidValueException {
		if (postGradNoSub.equals(""))
			throw new EmptyValueException("postGradNoSub");
		else
			try {
				this.postGradNoSub = Integer.parseInt(postGradNoSub);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("postGradNoSub");
			}
	}
	public Integer getPostGradMarks() {
		return postGradMarks;
	}

	public void setPostGradMarks(String postGradMarks) throws EmptyValueException, InvalidValueException {
		if (postGradMarks.equals(""))
			throw new EmptyValueException("postGradMarks");
		else
			try {
				this.postGradMarks = Integer.parseInt(postGradMarks);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("postGradMarks");
			}
	}
	public Integer getOtherScore() {
		return otherScore;
	}

	public void setOtherScore(String otherScore) throws EmptyValueException, InvalidValueException {
		if (otherScore.equals(""))
			throw new EmptyValueException("otherScore");
		else
			try {
				this.otherScore = Integer.parseInt(otherScore);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("otherScore");
			}
	}
	public Integer getOtherRank() {
		return otherRank;
	}
	public void setOtherRank(String otherRank) throws EmptyValueException, InvalidValueException {
		if (otherRank.equals(""))
			throw new EmptyValueException("otherRank");
		else
			try {
				this.otherRank = Integer.parseInt(otherRank);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("otherRank");
			}
	}
	public Integer getOtherYear() {
		return otherYear;
	}
	public void setOtherYear(String otherYear) throws EmptyValueException, InvalidValueException {
		if (otherYear.equals(""))
			throw new EmptyValueException("otherYear");
		else
			try {
				this.otherYear = Integer.parseInt(otherYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("otherYear");
			}
	}
	public Integer getGateMarks() {
		return gateMarks;
	}
	public void setGateMarks(String gateMarks) throws EmptyValueException, InvalidValueException {
		if (gateMarks.equals(""))
			throw new EmptyValueException("gateMarks");
		else
			try {
				this.gateMarks = Integer.parseInt(gateMarks);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gateMarks");
			}
	}
	public Integer getGateScore() {
		return gateScore;
	}
	public void setGateScore(String gateScore) throws EmptyValueException, InvalidValueException {
		if (gateScore.equals(""))
			throw new EmptyValueException("gateScore");
		else
			try {
				this.gateScore = Integer.parseInt(gateScore);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gateScore");
			}
	}
	public Integer getGateRank() {
		return gateRank;
	}
	public void setGateRank(String gateRank) throws EmptyValueException, InvalidValueException {
		if (gateRank.equals(""))
			throw new EmptyValueException("gateRank");
		else
			try {
				this.gateRank = Integer.parseInt(gateRank);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gateRank");
			}
	}
	public Integer getGateYear() {
		return gateYear;
	}
	public void setGateYear(String gateYear) throws EmptyValueException, InvalidValueException {
		if (gateYear.equals(""))
			throw new EmptyValueException("gateYear");
		else
			try {
				this.gateYear = Integer.parseInt(gateYear);
			} catch (NumberFormatException e) {
				throw new InvalidValueException("gateYear");
			}
	}
	public Boolean getPhysicallyDisabled() {
		return physicallyDisabled;
	}
	public void setPhysicallyDisabled(String physicallyDisabled) {
		this.physicallyDisabled = physicallyDisabled.equals("Yes");
	}
	public Boolean getDefenceConcession() {
		return defenceConcession;
	}
	public void setDefenceConcession(String defenceConcession) {
		this.defenceConcession = defenceConcession.equals("Yes");
	}
	public Boolean getEce() {
		return ece;
	}
	public void setEce(Boolean ece) {
		this.ece = ece;
	}
	public Boolean getPostGrad() {
		return postGrad;
	}
	public void setPostGrad(Boolean postGrad) {
		this.postGrad = postGrad;
	}
	public Boolean getOther() {
		return other;
	}
	public void setOther(Boolean other) {
		this.other = other;
	}
	public Boolean getGate() {
		return gate;
	}
	public void setGate(Boolean gate) {
		this.gate = gate;
	}

	private String name;
	private String enrollNo;
	private String address;
	private String mobileNo;
	private String phdStream;
	private String areaPref1;
	private String areaPref2;
	private String areaPref3;
	private String email;
	private String dob;
	private String gender;
	private String category;
	private Boolean physicallyDisabled;
	private Boolean defenceConcession;
	private String fatherName;
	private String nationality;
	private String permAddress;
	private String pinCode;
	private String xBoard;
	private Integer xBoardPercent;
	private Integer xBoardYear;
	private String xiiBoard;
	private Integer xiiBoardPercent;
	private Integer xiiBoardYear;
	private String gradDegree;
	private String gradDepartment;
	private String gradCollege;
	private String gradUniversity;
	private String gradCity;
	private String gradState;
	private Integer gradYear;
	private String gradScore;
	private Integer gradCGPA;
	private Integer gradNoSub;
	private Integer gradMarks;
	private Boolean ece;
	private String ecePref1;
	private String ecePref2;
	private String ecePref3;
	private String ecePref4;
	private Boolean postGrad;
	private String postGradDegree;
	private String postGradDepartment;
	private String postGradCollege;
	private String postGradUniversity;
	private String postGradCity;
	private String postGradState;
	private Integer postGradYear;
	private String postGradScore;
	private Integer postGradCGPA;
	private Integer postGradNoSub;
	private Integer postGradMarks;
	private Boolean other;
	private String otherExamName;
	private String otherSubject;
	private Integer otherScore;
	private Integer otherRank;
	private Integer otherYear;
	private Boolean gate;
	private String gateArea;
	private Integer gateMarks;
	private Integer gateScore;
	private Integer gateRank;
	private Integer gateYear;
	private String achievements;

}
